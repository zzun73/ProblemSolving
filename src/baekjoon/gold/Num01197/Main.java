package baekjoon.gold.Num01197;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start, target, cost;

    public Edge(int start, int target, int cost) {
        this.start = start;
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int N, M, a, b, c, answer, edgeCount;
    static int[] root;
    static PriorityQueue<Edge> pq;

    static void init() {
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }
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

    static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    static void helper() {

        while (!pq.isEmpty()) {
            if (edgeCount == N - 1) {
                break;
            }
            Edge e = pq.poll();

            if (find(e.start) != find(e.target)) {
                answer += e.cost;
                edgeCount++;
                union(e.start, e.target);
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
        root = new int[N];
        pq = new PriorityQueue<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, c));
        }

        init();
        helper();
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
