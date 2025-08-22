package baekjoon.gold.Num01719;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int target, weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    private static final int INF = Integer.MAX_VALUE;
    static int n;
    static List<Node>[] graph;
    static int[] distance, road;

    static void helper(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance = new int[n + 1];
        road = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = INF;
            road[i] = -1;
        }
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > distance[cur.target]) {
                continue;
            }

            for (Node next : graph[cur.target]) {
                int weightSum = next.weight + cur.weight;

                if (weightSum < distance[next.target]) {
                    if (cur.target == start) {
                        road[next.target] = next.target;
                    } else {
                        road[next.target] = road[cur.target];
                    }

                    distance[next.target] = weightSum;
                    pq.add(new Node(next.target, weightSum));
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
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }

        for (int i = 1; i <= n; i++) {
            helper(i);

            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    sb.append("-").append(" ");
                    continue;
                }
                sb.append(road[j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}