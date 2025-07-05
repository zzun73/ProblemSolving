package baekjoon.gold.Num14217;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] visited;
    static int[][] map;

    static void helper() {
        Deque<Integer> deque = new ArrayDeque<>();
        visited = new int[n + 1];
        deque.add(1);
        Arrays.fill(visited, -1);
        visited[1] = 0;

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            for (int next = 1; next <= n; next++) {
                if (visited[next] == -1 && map[cur][next] == 1) {
                    visited[next] = visited[cur] + 1;
                    deque.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (a == 1) {
                map[i][j] = map[j][i] = 1;
            } else if (a == 2) {
                map[i][j] = map[j][i] = 0;
            }

            helper();

            for (int k = 1; k <= n; k++) {
                sb.append(visited[k]).append(" ");
            }
            sb.append("\n");

        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}