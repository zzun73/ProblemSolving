package baekjoon.gold.Num18402;

import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int target, time;

        public Edge(int target, int time) {
            this.target = target;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }

    static int N;
    static List<Edge>[] grpah;
    static int[] distance;

    static void helper(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.time > distance[cur.target]) {
                continue;
            }

            for (Edge next : grpah[cur.target]) {
                int timeSum = cur.time + next.time;
                if (timeSum < distance[next.target]) {
                    distance[next.target] = timeSum;
                    pq.add(new Edge(next.target, timeSum));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        int E = Integer.parseInt(br.readLine().trim());
        int T = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());


        grpah = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            grpah[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            grpah[B].add(new Edge(A, time));
        }

        int answer = 0;
        helper(E);

        for (int i = 1; i <= N; i++) {
            if (distance[i] <= T) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}