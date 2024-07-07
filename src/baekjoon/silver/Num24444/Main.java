package baekjoon.silver.Num24444;

import java.io.*;
import java.util.*;

public class Main {
    static int N, R;
    static List<List<Integer>> list;
    static int[] visited;
    static Deque<Integer> deque;

    static void helper() {
        int cnt = 1;
        deque.add(R);
        visited[R] = cnt++;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : list.get(cur)) {
                if (visited[next] == 0) {
                    visited[next] = cnt++;
                    deque.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        deque = new ArrayDeque<>();
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (List<Integer> node : list) {
            Collections.sort(node);
        }

        helper();

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}