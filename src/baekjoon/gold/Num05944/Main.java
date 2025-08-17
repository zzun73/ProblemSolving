package baekjoon.gold.Num05944;

import java.io.*;
import java.util.*;

public class Main {
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

    private static final int INF = Integer.MAX_VALUE;
    static int C, P, PB, PA1, PA2;
    static List<Edge>[] list;
    static int[] distance;
    static PriorityQueue<Edge> pq;

    static int[] dijkstra(int start) {
        distance = new int[P + 1];
        Arrays.fill(distance, INF);

        pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (distance[cur.target] < cur.weight) {
                continue;
            }

            for (Edge next : list[cur.target]) {
                int weightSum = cur.weight + next.weight;
                if (weightSum < distance[next.target]) {
                    distance[next.target] = weightSum;
                    pq.add(new Edge(next.target, weightSum));
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
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        PB = Integer.parseInt(st.nextToken());
        PA1 = Integer.parseInt(st.nextToken());
        PA2 = Integer.parseInt(st.nextToken());

        list = new ArrayList[P + 1];
        for (int i = 1; i <= P; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int P1 = Integer.parseInt(st.nextToken());
            int P2 = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            list[P1].add(new Edge(P2, D));
            list[P2].add(new Edge(P1, D));
        }

        int[] distFromPB = dijkstra(PB);
        int[] distFromPA1 = dijkstra(PA1);
        int[] distFromPA2 = dijkstra(PA2);

        int route1 = distFromPB[PA1] + distFromPA1[PA2];
        int route2 = distFromPB[PA2] + distFromPA2[PA1];
        int answer = Math.min(route1, route2);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}