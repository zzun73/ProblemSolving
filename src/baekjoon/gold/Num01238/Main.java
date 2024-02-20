package baekjoon.gold.Num01238;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
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

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int N, M, X, A, B, T;
    static PriorityQueue<Edge> pq;

    static int[] helper(List<Edge>[] edges) {
        int[] distance = new int[N];
        Arrays.fill(distance, INF);
        distance[X] = 0;

        pq.add(new Edge(X, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (distance[cur.target] < cur.cost) {
                continue;
            }

            for (Edge next : edges[cur.target]) {
                int weightSum = next.cost + cur.cost;
                if (distance[next.target] > weightSum) {
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        List<Edge>[] go = new ArrayList[N];
        List<Edge>[] back = new ArrayList[N];
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            go[i] = new ArrayList<>();
            back[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken()) - 1;
            B = Integer.parseInt(st.nextToken()) - 1;
            T = Integer.parseInt(st.nextToken());
            go[A].add(new Edge(B, T));
            back[B].add(new Edge(A, T));
        }

        int[] goD = helper(go);
        int[] backD = helper(back);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, goD[i] + backD[i]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
