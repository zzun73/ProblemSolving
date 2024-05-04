package baekjoon.gold.Num13418;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start, target, type;

    public Edge(int start, int target, int type) {
        this.start = start;
        this.target = target;
        this.type = type;
    }

    @Override
    public int compareTo(Edge o) {
        return this.type - o.type;
    }
}

public class Main {
    static int N, M, A, B, C, min, max, answer;
    static int[] root;
    static PriorityQueue<Edge> maxPq, minPq;

    static void init() {
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (root[pa] < root[pb]) {
            root[pb] = root[pa];
        } else {
            root[pa] = pb;
        }
    }

    static int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    static int helper(PriorityQueue<Edge> pq) {
        int edgeCount = 0;
        int cost = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (find(cur.start) != find(cur.target)) {
                if (cur.type == 0) {
                    cost++;
                }
                union(cur.start, cur.target);
                edgeCount++;
            }

            if (edgeCount == N) {
                return cost;
            }
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        M++; // 입구와 1번도로 연결관계
        root = new int[N + 1];

        maxPq = new PriorityQueue<>();
        minPq = new PriorityQueue<>(Collections.reverseOrder());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            Edge e = new Edge(A, B, C);
            maxPq.add(e);
            minPq.add(e);
        }
        init();
        max = helper(maxPq);

        init();
        min = helper(minPq);

        answer = (max * max) - (min * min);
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}