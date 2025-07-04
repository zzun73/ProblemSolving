package baekjoon.gold.Num01245;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[][] map;
    static boolean[][] visited;

    static boolean helper(int x, int y) {
        boolean isPeak = true;
        int height = map[x][y];
        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[]{x, y});
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!isIn(nx, ny)) {
                    continue;
                }

                if (map[nx][ny] > height) {
                    isPeak = false;
                }

                if (!visited[nx][ny] && map[nx][ny] == height) {
                    deque.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return isPeak;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    answer += helper(i, j) ? 1 : 0;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}