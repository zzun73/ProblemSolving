package baekjoon.silver.Num24482;

import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static List<Integer>[] edges;

    static void helper(int vertex) {
        for (int next : edges[vertex]) {
            if (visited[next] == -1) {
                visited[next] = visited[vertex] + 1;
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
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        visited = new int[N + 1];
        Arrays.fill(visited, -1);

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

        visited[R] = 0;
        helper(R);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}