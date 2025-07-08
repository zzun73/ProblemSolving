package baekjoon.gold.Num33905;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, answer;
    static List<Integer>[] edge;
    static Set<Integer> block;

    static void helper() {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 2];
        deque.add(1);
        visited[1] = true;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : edge[cur]) {
                if (!visited[next] && !block.contains(next)) {
                    visited[next] = true;
                    deque.add(next);
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        block = new HashSet<>();
        edge = new ArrayList[N + 2];
        for (int i = 0; i < edge.length; i++) {
            edge[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edge[u].add(v);
            edge[v].add(u);
        }

        st = new StringTokenizer(br.readLine(), " ");
        while (K-- > 0) {
            block.add(Integer.parseInt(st.nextToken()));
        }

        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}