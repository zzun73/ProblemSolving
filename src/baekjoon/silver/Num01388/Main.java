package baekjoon.silver.Num01388;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] board;

    public static void helper(int x, int y, char cur) {
        if (x < 0 || x > N - 1 || y < 0 || y > M - 1 || board[x][y] == 'x' || cur != board[x][y]) {
            return;
        }

        if (board[x][y] == '|') {
            board[x][y] = 'x';
            helper(x + 1, y, '|');
        }
        if (board[x][y] == '-') {
            board[x][y] = 'x';
            helper(x, y + 1, '-');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = input[j];
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 'x') {
                    helper(i, j, board[i][j]);
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
