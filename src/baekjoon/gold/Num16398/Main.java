package baekjoon.gold.Num16398;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int target;
    long cost;

    public Edge(int target, long cost) {
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.cost, o.cost);
    }
}

public class Main {
    static int N;
    static long answer;
    static int[][] arr;
    static List<Edge>[] edges;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;

    static void helper() {
        pq.add(new Edge(0, 0));
        int edgeCount;
        long totalCost;
        totalCost = edgeCount = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.target]) {
                continue;
            }
            visited[cur.target] = true;
            totalCost += cur.cost;

            if (edgeCount++ == N - 1) {
                break;
            }

            for (Edge next : edges[cur.target]) {
                if (!visited[next.target]) {
                    pq.add(next);
                }
            }
        }

        answer = totalCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        edges = new ArrayList[N];
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i != j) {
                    edges[i].add(new Edge(j, arr[i][j]));
                }
            }
        }

        helper();
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}