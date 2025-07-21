package baekjoon.silver.Num21937;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;

    static int helper(int target) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int result = 0;

        deque.add(target);
        visited[target] = true;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    deque.add(next);
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        int X = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(helper(X)));

        br.close();
        bw.close();
    }
}