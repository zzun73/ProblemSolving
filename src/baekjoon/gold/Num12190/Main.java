package baekjoon.gold.Num12190;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N, answer;
    static char[][] map;
    static int[][] trap;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean[][] visited;
    static Deque<int[]> deque;

    static void mark() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') {
                    trap[i][j] = -1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < 8; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (!isIn(nx, ny)) {
                        continue;
                    }

                    if (map[nx][ny] == '*') {
                        count++;
                    }
                }
                trap[i][j] = count;
            }
        }
    }

    static void helper(int x, int y) {
        deque.add(new int[]{x, y});
        visited[x][y] = true;
        answer++;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!isIn(nx, ny)) {
                    continue;
                }

                if (map[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (trap[nx][ny] == 0) {
                        deque.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            trap = new int[N][N];
            visited = new boolean[N][N];
            deque = new ArrayDeque<>();
            answer = 0;

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            mark();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j] && trap[i][j] == 0) {
                        helper(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j]) {
                        visited[i][j] = true;
                        answer++;
                    }
                }
            }

            sb.append("Case #").append(t).append(": ").append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
