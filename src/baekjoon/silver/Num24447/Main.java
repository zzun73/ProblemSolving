package baekjoon.silver.Num24447;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, counter;
    static int[] depth;
    static int[] order;
    static List<Integer>[] edges;

    static void helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        deque.add(new int[]{R, 0});
        visited[R] = true;
        depth[R] = 0;
        order[R] = ++counter;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int v = cur[0];
            int d = cur[1];
            depth[v] = d;

            for (int next : edges[v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    order[next] = ++counter;
                    deque.add(new int[]{next, d + 1});
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
        R = Integer.parseInt(st.nextToken());
        counter = 0;
        edges = new ArrayList[N + 1];
        depth = new int[N + 1];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        Arrays.fill(depth, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(edges[i]);
        }

        helper();

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += (long) depth[i] * order[i];
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}