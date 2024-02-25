package baekjoon.gold.Num01647;

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
    static int N, M, A, B, C, edgeCount, totalCost, maxCost;
    static PriorityQueue<Edge> pq;
    static int[] root;

    static void init() {
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (root[a] < root[b]) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }

    static int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    static int helper() {

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (edgeCount == N - 1) {
                break;
            }

            if (find(cur.start) != find(cur.target)) {
                edgeCount++;
                maxCost = Math.max(maxCost, cur.cost);
                totalCost += cur.cost;
                union(cur.start, cur.target);
            }
        }
        return totalCost - maxCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        root = new int[N];
        init();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken()) - 1;
            B = Integer.parseInt(st.nextToken()) - 1;
            C = Integer.parseInt(st.nextToken());

            pq.add(new Edge(A, B, C));
        }
        bw.write(String.valueOf(helper()));
        br.close();
        bw.close();
    }
}

//package baekjoon.gold.Num01647;
//
//import java.io.*;
//import java.util.*;
//
//class Edge implements Comparable<Edge> {
//    int target, cost;
//
//    public Edge(int target, int cost) {
//        this.target = target;
//        this.cost = cost;
//    }
//
//    @Override
//    public int compareTo(Edge o) {
//        return this.cost - o.cost;
//    }
//}
//
//public class Main {
//    static int N, M, A, B, C, edgeCount, totalCost, maxCost;
//    static List<Edge>[] edges;
//    static PriorityQueue<Edge> pq;
//    static boolean[] visited;
//
//    static int helper() {
//        pq.add(new Edge(0, 0));
//        totalCost = edgeCount = maxCost = 0;
//
//        while (!pq.isEmpty()) {
//            Edge cur = pq.poll();
//
//            if (visited[cur.target]) {
//                continue;
//            }
//
//            if (edgeCount == N - 1) {
//                break;
//            }
//
//            visited[cur.target] = true;
//            totalCost += cur.cost;
//            maxCost = Math.max(maxCost, cur.cost);
//
//            for (Edge next : edges[cur.target]) {
//                if (!visited[next.target]) {
//                    pq.add(next);
//                }
//            }
//        }
//        return totalCost - maxCost;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        edges = new ArrayList[N];
//        visited = new boolean[N];
//        pq = new PriorityQueue<>();
//
//        for (int i = 0; i < N; i++) {
//            edges[i] = new ArrayList<>();
//        }
//
//        while (M-- > 0) {
//            st = new StringTokenizer(br.readLine(), " ");
//            A = Integer.parseInt(st.nextToken()) - 1;
//            B = Integer.parseInt(st.nextToken()) - 1;
//            C = Integer.parseInt(st.nextToken());
//
//            edges[A].add(new Edge(B, C));
//            edges[B].add(new Edge(A, C));
//        }
//        bw.write(String.valueOf(helper()));
//        br.close();
//        bw.close();
//    }
//}