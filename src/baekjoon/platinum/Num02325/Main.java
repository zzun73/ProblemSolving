package baekjoon.platinum.Num02325;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int target, cost;

    public Edge(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }

    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    private static final int INF = 10_000_000;
    static int N, M;
    static List<Edge>[] edges;
    static Deque<Edge> deque;
    static int[] distance, path;
    static boolean[] check;

    static void helper(boolean isDelete) {
        Arrays.fill(distance, INF);
        deque.add(new Edge(1, 0));
        distance[1] = 0;


        while (!deque.isEmpty()) {
            Edge cur = deque.poll();

            if (distance[cur.target] < cur.cost) {
                continue;
            }

            for (Edge next : edges[cur.target]) {
                int weightSum = next.cost + cur.cost;
                if (check[cur.target] && check[next.target]) {
                    continue;
                }
                if (weightSum < distance[next.target]) {

                    if (!isDelete) {
                        path[next.target] = cur.target;
                    }

                    distance[next.target] = weightSum;
                    deque.add(new Edge(next.target, distance[next.target]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        deque = new ArrayDeque<>();
        distance = new int[N + 1];
        path = new int[N + 1];
        check = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            edges[x].add(new Edge(y, z));
            edges[y].add(new Edge(x, z));
        }
        helper(false);

        int answer = 0;
        int idx = N;
        while (idx != 1) {
            int v1 = idx;
            idx = path[idx];
            int v2 = idx;
            check[v1] = check[v2] = true;
            helper(true);
            check[v1] = check[v2] = false;
            answer = Math.max(answer, distance[N]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}