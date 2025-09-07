package baekjoon.gold.Num17835;

import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int target;
        long weight;

        public Edge(int target, long weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    private static final long INF = Long.MAX_VALUE / 4;
    static int N;
    static List<Edge>[] graph;
    static int[] sp;

    static long[] helper() {
        long[] distance = new long[N + 1];
        Arrays.fill(distance, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int start : sp) {
            distance[start] = 0;
            pq.add(new Edge(start, distance[start]));
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (distance[cur.target] < cur.weight) {
                continue;
            }

            for (Edge next : graph[cur.target]) {
                long weightSum = next.weight + cur.weight;

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
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[V].add(new Edge(U, C));
        }

        sp = new int[K];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            sp[i] = Integer.parseInt(st.nextToken());
        }

        int answerIndex = -1;
        long answerDistance = -1;
        long[] res = helper();

        for (int i = 1; i <= N; i++) {
            if (res[i] == INF) {
                continue;
            }

            if (res[i] > answerDistance || (res[i] == answerDistance && i < answerIndex)) {
                answerDistance = res[i];
                answerIndex = i;
            }
        }

        sb.append(answerIndex).append("\n").append(answerDistance);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}