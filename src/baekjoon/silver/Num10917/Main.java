package baekjoon.silver.Num10917;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static boolean[] visited;
    static List<Integer>[] edges;
    static Deque<int[]> deque;

    static void helper() {
        visited = new boolean[N + 1];
        visited[1] = true;

        deque = new ArrayDeque<>();
        deque.add(new int[]{1, 0});


        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (cur[1] > answer) {
                continue;
            }

            if (cur[0] == N) {
                answer = Math.min(cur[1], answer);
            }

            for (int next : edges[cur[0]]) {
                if (!visited[next]) {
                    deque.add(new int[]{next, cur[1] + 1});
                    visited[next] = true;
                }
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

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges[x].add(y);
        }

        answer = Integer.MAX_VALUE;
        helper();

        answer = answer == Integer.MAX_VALUE ? -1 : answer;

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}