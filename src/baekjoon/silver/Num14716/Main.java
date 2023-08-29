package baekjoon.silver.Num14716;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void helper(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N || board[x][y] != 1) {
            return;
        }

        board[x][y] = 2;
        for (int i = 0; i < dx.length; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
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

        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    helper(i, j);
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
