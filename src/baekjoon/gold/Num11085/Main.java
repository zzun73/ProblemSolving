package baekjoon.gold.Num11085;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start, target, width;

        public Edge(int start, int target, int width) {
            this.start = start;
            this.target = target;
            this.width = width;
        }

        @Override
        public int compareTo(Edge o) {
            return o.width - this.width;
        }
    }

    static int p, w, c, v;
    static int[] root;
    static PriorityQueue<Edge> pq;

    static void init() {
        for (int i = 0; i < p; i++) {
            root[i] = i;
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa < pb) {
            root[pb] = pa;
        } else {
            root[pa] = pb;
        }
    }

    static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    static int helper() {
        int res = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (find(cur.start) != find(cur.target)) {
                union(cur.start, cur.target);
                res = cur.width;
            }

            if(find(c) == find(v)){
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        p = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        c = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        root = new int[p];
        init();
        pq = new PriorityQueue<>();
        while (w-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            pq.add(new Edge(start, end, width));
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.flush();
        bw.close();
    }
}