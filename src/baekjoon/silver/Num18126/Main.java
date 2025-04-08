package baekjoon.silver.Num18126;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long answer;
    static boolean[] visited;
    static List<Node>[] edges;

    static class Node {
        int vertex;
        long distance;

        public Node(int vertex, long distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static void helper(int v, long len) {
        answer = Math.max(answer, len);
        visited[v] = true;

        for (Node node : edges[v]) {
            if (!visited[node.vertex]) {
                helper(node.vertex, len + node.distance);
            }
        }
        visited[v] = false;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = 0;

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[A].add(new Node(B, C));
            edges[B].add(new Node(A, C));
        }

        helper(1, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
