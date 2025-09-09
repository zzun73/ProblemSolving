package baekjoon.gold.Num01240;

import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int target, weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static int N;
    static List<Edge>[] graph;

    static int helper(int start, int end) {
        Deque<Edge> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        deque.add(new Edge(start, 0));

        while (!deque.isEmpty()) {
            Edge cur = deque.poll();
            if (cur.target == end) {
                return cur.weight;
            }
            for (Edge next : graph[cur.target]) {
                if (!visited[next.target]) {
                    visited[next.target] = true;
                    deque.add(new Edge(next.target, cur.weight + next.weight));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(helper(s, e)).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}