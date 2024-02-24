package baekjoon.gold.Num01504;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int target, cost;

    public Edge(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int N, E, a, b, c, u, v;
    static long[] distance;
    static long answer, path1, path2;
    static List<Edge>[] edges;
    static PriorityQueue<Edge> pq;

    static long helper(int start, int target) {
        pq = new PriorityQueue<>();
        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (distance[cur.target] < cur.cost) {
                continue;
            }

            for (Edge next : edges[cur.target]) {
                int weightSum = next.cost + cur.cost;
                if (weightSum < distance[next.target]) {
                    distance[next.target] = weightSum;
                    pq.add(new Edge(next.target, weightSum));
                }
            }
        }

        return distance[target];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N];
        distance = new long[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        u = Integer.parseInt(st.nextToken()) - 1;
        v = Integer.parseInt(st.nextToken()) - 1;

        path1 = helper(0, u) + helper(u, v) + helper(v, N - 1);
        path2 = helper(0, v) + helper(v, u) + helper(u, N - 1);

        answer = Math.min(path1, path2);

        if (answer >= Integer.MAX_VALUE) {
            answer = -1;
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}