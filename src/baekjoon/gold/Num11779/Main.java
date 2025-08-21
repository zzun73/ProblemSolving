package baekjoon.gold.Num11779;

import java.io.*;
import java.util.*;

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

    static List<Node>[] graph;
    static int[] distance, parent;

    static void helper(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
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
                    parent[next.target] = cur.target;
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

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        distance = new int[N + 1];
        parent = new int[N + 1];
        Arrays.fill(distance, 100_000_000);
        Arrays.fill(parent, -1);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, val));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        helper(start);

        List<Integer> path = new ArrayList<>();
        for (int cur = end; cur != -1; cur = parent[cur]) {
            path.add(cur);
        }

        sb.append(distance[end]).append("\n");
        sb.append(path.size()).append("\n");
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}