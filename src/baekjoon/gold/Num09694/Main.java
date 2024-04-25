package baekjoon.gold.Num09694;

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

    private static final int INF = 100_000_000;
    static int T, N, M, x, y, z;
    static int[] path, distance;
    static List<Edge>[] edges;
    static PriorityQueue<Edge> pq;

    static void helper() {
        distance[0] = 0;
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > distance[cur.target]) {
                continue;
            }

            for (Edge next : edges[cur.target]) {
                int weightSum = next.cost + cur.cost;

                if (weightSum < distance[next.target]) {
                    distance[next.target] = weightSum;
                    path[next.target] = cur.target;
                    pq.add(new Edge(next.target, distance[next.target]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            pq = new PriorityQueue<>();
            distance = new int[M];
            path = new int[M];
            edges = new ArrayList[M];

            Arrays.fill(distance, INF);
            for (int i = 0; i < M; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());
                edges[x].add(new Edge(y, z));
                edges[y].add(new Edge(x, z));
            }
            helper();

            if (distance[M - 1] == INF) {
                sb.append("Case").append(" ").append("#").append(t).append(":").append(" ").append(-1);
            } else {
                int idx = M - 1;
                Deque<Integer> deque = new ArrayDeque<>();
                while (idx != 0) {
                    deque.add(idx);
                    idx = path[idx];
                }
                deque.add(idx);
                sb.append("Case").append(" ").append("#").append(t).append(":").append(" ");
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast()).append(" ");
                }
            }
            sb.append("\n");

        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}