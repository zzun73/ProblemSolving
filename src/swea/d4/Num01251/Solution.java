package swea.d4.Num01251;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start, target;
    double cost;

    public Edge(int start, int target, double cost) {
        this.start = start;
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.cost, o.cost);
    }
}

public class Solution {
    static int T, N, edgeCount;
    static double E;
    static double answer;
    static int[] root, xpos, ypos;
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

    static double setDistance(int i, int j) {
        return Math.pow(
                Math.sqrt((Math.pow(Math.abs(xpos[i] - xpos[j]), 2) + Math.pow(Math.abs(ypos[i] - ypos[j]), 2))), 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            xpos = new int[N];
            ypos = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                xpos[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                ypos[i] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());
            root = new int[N];
            pq = new PriorityQueue<>();
            answer = 0;
            edgeCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j && i <= j) {
                        pq.add(new Edge(i, j, setDistance(i, j)));
                    }
                }
            }

            init();
            helper();
            sb.append("#").append(t).append(" ").append((long) Math.round(answer * E / 1.0)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}