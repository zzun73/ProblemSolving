package baekjoon.silver.Num18232;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, E;
    static List<Integer>[] edges;

    static int helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        deque.add(new int[]{S, 0});
        visited[S] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            if (cur[0] == E) {
                return cur[1];
            }

            for (int n : edges[cur[0]]) {
                if (n <= N && !visited[n]) {
                    visited[n] = true;
                    deque.add(new int[]{n, cur[1] + 1});
                }
            }

            int next = cur[0] + 1;
            if (next <= N && !visited[next]) {
                visited[next] = true;
                deque.add(new int[]{next, cur[1] + 1});
            }
            next = cur[0] - 1;
            if (next >= 1 && !visited[next]) {
                visited[next] = true;
                deque.add(new int[]{next, cur[1] + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}
