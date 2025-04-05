package baekjoon.silver.Num01260;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] edges;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int v) {
        sb.append(v).append(" ");
        visited[v] = true;

        for (int next : edges[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int v) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(v);
        visited[v] = true;
        sb.append(v).append(" ");

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : edges[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    deque.add(next);
                    sb.append(next).append(" ");
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edges[v1].add(v2);
            edges[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(edges[i]);
        }

        dfs(V);
        visited = new boolean[N + 1];
        sb.append("\n");
        bfs(V);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}

