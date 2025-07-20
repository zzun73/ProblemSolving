package baekjoon.gold.Num05996;

import java.io.*;
import java.util.*;

public class Main {
    static int T, C, S, E;

    static class Edge implements Comparable<Edge> {
        int target, weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static List<Edge>[] list;
    static int[] distance;
    static PriorityQueue<Edge> pq;

    static void helper() {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        pq.add(new Edge(S, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.weight > distance[cur.target]) {
                continue;
            }

            for (Edge next : list[cur.target]) {
                int weightSum = cur.weight + next.weight;

                if (distance[next.target] > weightSum) {
                    distance[next.target] = weightSum;
                    pq.add(new Edge(next.target, weightSum));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[T + 1];
        distance = new int[T + 1];
        pq = new PriorityQueue<>();

        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        while (C-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
            list[v].add(new Edge(u, w));
        }

        helper();

        bw.write(String.valueOf(distance[E]));

        br.close();
        bw.close();
    }
}