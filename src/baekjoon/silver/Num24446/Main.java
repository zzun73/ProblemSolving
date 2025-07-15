package baekjoon.silver.Num24446;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[] answer;
    static List<Integer>[] edges;

    static void helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        deque.add(new int[]{R, 0});
        visited[R] = true;
        answer[R] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int vertex = cur[0];
            int depth = cur[1];
            answer[vertex] = depth;

            for (int next : edges[vertex]) {
                if (!visited[next]) {
                    visited[next] = true;
                    deque.add(new int[]{next, depth + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }
        Arrays.fill(answer, -1);

        helper();

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}