package baekjoon.gold.Num15591;

import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int next, value;

        public Point(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    static int N;
    static List<Point>[] edges;

    static int helper(int k, int v) {
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        deque.add(v);
        visited[v] = true;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (Point point : edges[cur]) {
                if (!visited[point.next] && point.value >= k) {
                    visited[point.next] = true;
                    deque.add(point.next);
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }


        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            edges[p].add(new Point(q, r));
            edges[q].add(new Point(p, r));
        }

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(helper(k, v)).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}