package baekjoon.gold.Num01753;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
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

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int V, E, K, u, v, w;
    static List<Edge>[] list;
    static int[] distance;
    static PriorityQueue<Edge> pq;

    static void helper() {
        Arrays.fill(distance, INF);
        distance[K] = 0;
        pq.add(new Edge(K, distance[K]));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.weight > distance[cur.target]) {
                continue;
            }

            for (Edge next : list[cur.target]) {
                int weightSum = next.weight + cur.weight;

                if (weightSum < distance[next.target]) {
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
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine()) - 1;
        list = new ArrayList[V];
        distance = new int[V];
        pq = new PriorityQueue<>();

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken()) - 1;
            v = Integer.parseInt(st.nextToken()) - 1;
            w = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v, w));
        }

        helper();

        for (int val : distance) {
            sb.append(val == INF ? "INF" : val).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}