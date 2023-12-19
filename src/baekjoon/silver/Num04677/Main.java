package baekjoon.silver.Num04677;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] board;
    static int[] dx = new int[]{0, -1, 0, 1, -1, -1, 1, 1};
    static int[] dy = new int[]{1, 0, -1, 0, 1, -1, 1, -1};

    public static void helper(int x, int y) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y});
        board[x][y] = '*';
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx > r - 1 || ny < 0 || ny > c - 1 || board[nx][ny] == '*') {
                    continue;
                }
                board[nx][ny] = '*';
                deque.add(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (r == 0 && c == 0) {
                break;
            }

            board = new char[r][c];
            for (int i = 0; i < r; i++) {
                char[] rows = br.readLine().toCharArray();
                for (int j = 0; j < c; j++) {
                    board[i][j] = rows[j];
                }
            }

            int answer = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] == '@') {
                        helper(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}