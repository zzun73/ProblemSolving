package baekjoon.gold.Num06067;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean[][] visited;

    static boolean helper(int sx, int sy) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        int h = map[sx][sy];
        boolean isHill = true;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (map[nx][ny] > h) {
                    isHill = false;
                }

                if (!visited[nx][ny] && map[nx][ny] == h) {
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny});
                }
            }
        }

        return isHill;
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
                if (!visited[i][j]) {
                    if (helper(i, j)) {
                        answer++;
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}