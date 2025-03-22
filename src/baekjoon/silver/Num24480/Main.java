package baekjoon.silver.Num24480;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<Integer>[] edges;
    static int[] record;
    static int count;
    static void helper(int node) {
        visited[node] = true;
        record[node] = count++;

        for (int next : edges[node]) {
            if (!visited[next]) {
                helper(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        record = new int[N + 1];
        count = 1;

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            edges[i].sort(Collections.reverseOrder());
        }

        helper(R);

        for (int i = 1; i <= N; i++) {
            sb.append(record[i]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}