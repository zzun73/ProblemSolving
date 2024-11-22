package baekjoon.gold.Num13905;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start, target, cost;

        public Edge(int start, int target, int cost) {
            this.start = start;
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return o.cost - this.cost;
        }
    }

    static int N, M, s, e, answer;
    static boolean isEnd;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static int[] root;

    static void init() {
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    static int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (root[pa] < root[pb]) {
            root[pb] = pa;
        } else {
            root[pa] = pb;
        }
    }

    static void helper() {
        init();
        int edgeCount;
        edgeCount = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (find(cur.start) != find(cur.target)) {
                answer = Math.min(answer, cur.cost);
                edgeCount++;
                union(cur.start, cur.target);

                if (find(s) == find(e)) {
                    isEnd = true;
                    break;
                }

            }

            if (edgeCount == N - 1) {
                return;
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

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        isEnd = false;
        answer = Integer.MAX_VALUE;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            pq.add(new Edge(h1, h2, k));
        }

        helper();

        bw.write(String.valueOf(isEnd ? answer : 0));

        br.close();
        bw.close();
    }
}