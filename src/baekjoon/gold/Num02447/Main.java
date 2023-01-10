package baekjoon.gold.Num02447;

import java.io.*;

public class Main {
    static char[][] board;

    public static void helper(int x, int y, int N, boolean blank) {
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    board[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            board[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) {
                    helper(i, j, size, true);
                } else {
                    helper(i, j, size, false);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        helper(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            bw.write(board[i]);
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
