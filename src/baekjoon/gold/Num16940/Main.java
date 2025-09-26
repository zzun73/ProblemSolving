package baekjoon.gold.Num16940;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] depth, path;
    static List<Integer>[] graph;

    static boolean helper() {
        boolean[] visited = new boolean[N + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        deque.add(1);
        visited[1] = true;

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            order.add(cur);
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    deque.add(next);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (order.get(i) != path[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        depth = new int[N + 1];
        boolean answer = true;

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        path = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }

        if (path[0] != 1) {
            answer = false;
        }

        if (answer) {
            int[] index = new int[N + 1];
            for (int i = 0; i < N; i++) {
                index[path[i]] = i;
            }

            for (int i = 1; i <= N; i++) {
                graph[i].sort(Comparator.comparingInt(a -> index[a]));
            }
            answer = helper();
        }

        bw.write(answer ? "1" : "0");

        br.close();
        bw.close();
    }
}