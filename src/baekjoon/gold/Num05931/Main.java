package baekjoon.gold.Num05931;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] board;
    static boolean[][] visited;
    static Deque<int[]> deque;

    static void mark(int x, int y, int number) {
        deque = new ArrayDeque<>();
        deque.add(new int[]{x, y});
        map[x][y] = number;
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!isIn(nx, ny) || visited[nx][ny] || board[nx][ny] == '.') {
                    continue;
                }

                deque.add(new int[]{nx, ny});
                map[nx][ny] = number;
                visited[nx][ny] = true;
            }
        }
    }


    static void helper() {
        deque = new ArrayDeque<>();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    deque.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (!isIn(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 2) {
                    answer = cost;
                    return;
                }

                if (map[nx][ny] == 1) {
                    deque.addFirst(new int[]{nx, ny, cost});
                    visited[nx][ny] = true;
                } else if (map[nx][ny] == 0) {
                    deque.addLast(new int[]{nx, ny, cost + 1});
                    visited[nx][ny] = true;
                }
            }
        }
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
        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int number = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    mark(i, j, number);
                    number++;
                }
            }
        }

        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}