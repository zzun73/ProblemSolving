package baekjoon.gold.Num17070;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[][] board;

    public static void helper(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1) {
            answer++;
            return;
        }

        if (y + 1 < N && board[x][y + 1] != 1 && dir != 1) {
            helper(x, y + 1, 0);
        }
        if (x + 1 < N && board[x + 1][y] != 1 && dir != 0) {
            helper(x + 1, y, 1);
        }
        if (x + 1 < N && y + 1 < N && board[x][y + 1] != 1 && board[x + 1][y] != 1 && board[x + 1][y + 1] != 1) {
            helper(x + 1, y + 1, 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        helper(0, 1, 0);

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
