package baekjoon.gold.Num01916;

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
    private static final int INF = 1_000_000_000;
    static int N, M, start, end;
    static List<Edge>[] list;
    static int[] dist;

    public static void helper() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, dist[start]));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (dist[cur.targetId] < cur.cost) {
                continue;
            }

            for (Edge next : list[cur.targetId]) {
                if (dist[next.targetId] > cur.cost + next.cost) {
                    dist[next.targetId] = cur.cost + next.cost;
                    pq.add(new Edge(next.targetId, dist[next.targetId]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        helper();
        bw.write(dist[end] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
