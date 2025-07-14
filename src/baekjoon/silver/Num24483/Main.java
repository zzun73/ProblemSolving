package baekjoon.silver.Num24483;

import java.io.*;
import java.util.*;

public class Main {
    static int order;
    static int[] depth, visited;
    static List<Integer>[] edges;

    static void helper(int vertex) {
        visited[vertex] = ++order;

        for (int next : edges[vertex]) {
            if (depth[next] == -1) {
                depth[next] = depth[vertex] + 1;
                helper(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        depth = new int[N + 1];
        visited = new int[N + 1];
        Arrays.fill(depth, -1);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(edges[i]);
        }

        depth[R] = 0;
        helper(R);

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += (long) depth[i] * visited[i];
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}