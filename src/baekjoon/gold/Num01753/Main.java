package baekjoon.gold.Num01753;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int targetId, cost;

    public Edge(int targetId, int cost) {
        this.targetId = targetId;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int N;
    static List<Edge>[] list;
    static int[] distance;

    private static void dijkstra(int startId) {
        distance[startId] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(startId, distance[startId]));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            System.out.println(cur.cost + "   " + distance[cur.targetId]);
            if (cur.cost != distance[cur.targetId]) {
                continue;
            }

            for (Edge next : list[cur.targetId]) {
                if (distance[next.targetId] > cur.cost + next.cost) {
                    distance[next.targetId] = cur.cost + next.cost;
                    pq.offer(new Edge(next.targetId, distance[next.targetId]));
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
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startId = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
        }

        dijkstra(startId);

        for (int i = 1; i <= N; i++) {
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
