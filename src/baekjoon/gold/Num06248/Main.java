package baekjoon.gold.Num06248;

import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int target, cost;

        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    static List<Edge>[] graph;

    static int helper(int start) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > distance[cur.target]) {
                continue;
            }

            for (Edge next : graph[cur.target]) {
                int costSum = cur.cost + next.cost;
                if (costSum < distance[next.target]) {
                    distance[next.target] = costSum;
                    pq.add(new Edge(next.target, costSum));
                }
            }
        }

        int res = 0;
        for (int val : distance) {
            if (val != Integer.MAX_VALUE) {
                res = Math.max(res, val);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, t));
            graph[b].add(new Edge(a, t));
        }

        bw.write(String.valueOf(helper(X) * 2));

        br.close();
        bw.close();
    }
}