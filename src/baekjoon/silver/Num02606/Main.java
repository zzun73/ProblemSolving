package baekjoon.silver.Num02606;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] edges;
    static boolean[] visited;

    static int helper() {
        int result = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        visited[1] = true;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : edges[cur]) {
                if (!visited[next]) {
                    result++;
                    visited[next] = true;
                    deque.add(next);
                }
            }
        }

        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        edges = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edges[v1].add(v2);
            edges[v2].add(v1);
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}
