package baekjoon.gold.Num01922;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {

    int start, next, cost;

    public Edge(int start, int next, int cost) {
        this.start = start;
        this.next = next;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

public class Main {
    static List<Edge> list;
    static PriorityQueue<Edge> pq;
    static int N, M;
    static int[] root;

    private static int getMST() {
        int answer = 0, edgeCount = 0;

        while (!pq.isEmpty()) {
            if (edgeCount == N - 1) break;

            Edge cur = pq.poll();
            if (find(cur.start) == find(cur.next)) continue;

            union(cur.start, cur.next);

            answer += cur.cost;
            edgeCount++;
        }
        return answer;
    }

    private static void init() {
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }
    }

    private static int find(int x) {
        if (root[x] == x) return x;

        return root[x] = find(root[x]);
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa > fb) {
            root[fa] = fb;
        } else {
            root[fb] = fa;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>(N + 1);
        root = new int[N + 1];
        init();
        pq = new PriorityQueue<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, c));
        }

        int answer = getMST();
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
