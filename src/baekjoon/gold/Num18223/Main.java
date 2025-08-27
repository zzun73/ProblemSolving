package baekjoon.gold.Num18223;

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

    static int V;
    static List<Edge>[] graph;


    static int[] helper(int start) {
        int[] distance = new int[V + 1];
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

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        int[] sToP = helper(1);
        int[] pToV = helper(P);

        int[] sToV = helper(1);

        bw.write(sToP[P] + pToV[V] <= sToV[V] ? "SAVE HIM" : "GOOD BYE");

        br.close();
        bw.close();
    }
}