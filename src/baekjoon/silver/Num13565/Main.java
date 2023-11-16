package baekjoon.silver.Num13565;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static char[][] board;
    static boolean flag;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void helper(int x, int y) {
        if (x == M - 1) {
            flag = true;
            return;
        }

        board[x][y] = '1';
        for (int i = 0; i < dx.length; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1 || board[nx][ny] == '1') {
                continue;
            }
            helper(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new char[M][N];
        flag = false;
        for (int i = 0; i < M; i++) {
            char[] rows = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                board[i][j] = rows[j];
            }
        }

        for (int i = 0; i < N; i++) {
            if (board[0][i] == '0') {
                helper(0, i);

                if (flag) {
                    break;
                }

            }
        }
        bw.write(flag ? "YES" : "NO");

        br.close();
        bw.flush();
        bw.close();
    }
}