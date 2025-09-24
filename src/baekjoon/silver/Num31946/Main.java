package baekjoon.silver.Num31946;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;
    static int[][] map;
    static boolean[][] visited;

    static void helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        visited = new boolean[N][M];
        deque.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int dx = -X; dx <= X; dx++) {
                for (int dy = -X; dy <= X; dy++) {
                    if (Math.abs(dx) + Math.abs(dy) > X) {
                        continue;
                    }
                    int nx = cx + dx;
                    int ny = cy + dy;

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] != map[0][0]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        X = Integer.parseInt(br.readLine());

        if (map[0][0] == map[N - 1][M - 1]) {
            helper();
        }

        bw.write(visited[N - 1][M - 1] ? "ALIVE" : "DEAD");

        br.close();
        bw.close();
    }
}