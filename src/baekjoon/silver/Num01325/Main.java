package baekjoon.silver.Num01325;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] edges;

    static int helper(int node) {
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[node] = true;
        deque.add(node);

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            result++;

            for (int next : edges[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    deque.add(next);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        edges = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges[v].add(u);
        }

        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!edges[i].isEmpty()) {
                int result = helper(i);
                if (answer < result) {
                    answer = result;
                    list.clear();
                    list.add(i);
                } else if (answer == result) {
                    list.add(i);
                }
            }
        }

        Collections.sort(list);
        for (int val : list) {
            sb.append(val).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}