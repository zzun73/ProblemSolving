package baekjoon.gold.Num09370;

import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int target, cost;

        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static List<Node>[] graph;
    static int[] destination;

    static int[] helper(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (distance[cur.target] < cur.cost) {
                continue;
            }

            for (Node next : graph[cur.target]) {
                int weightSum = next.cost + cur.cost;

                if (weightSum < distance[next.target]) {
                    distance[next.target] = weightSum;
                    pq.add(new Node(next.target, weightSum));
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

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            destination = new int[t];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            int path = 0;
            List<Integer> answers = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));

                if ((a == g && b == h) || (a == h && b == g)) {
                    path = d;
                }
            }

            int[] sDistance = helper(s);
            int[] gDistance = helper(g);
            int[] hDistance = helper(h);

            for (int i = 0; i < t; i++) {
                int end = Integer.parseInt(br.readLine());

                int pathG = sDistance[g] + hDistance[end] + path;
                int pathH = sDistance[h] + gDistance[end] + path;
                if (pathG == sDistance[end] || pathH == sDistance[end]) {
                    answers.add(end);
                }
            }

            Collections.sort(answers);
            for (Integer answer : answers) {
                sb.append(answer).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}