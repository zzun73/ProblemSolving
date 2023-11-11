package swea.d3.Num15612;

import java.io.*;

public class Solution {
    private static final int SIZE = 8;
    static char[][] board;

    public static boolean helper() {
        for (int i = 0; i < SIZE; i++) {
            int cnt = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 'O') {
                    cnt++;
                }
            }
            if (cnt != 1) {
                return false;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            int cnt = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[j][i] == 'O') {
                    cnt++;
                }
            }
            if (cnt != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            board = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = input[j];
                }
            }
            sb.append("#").append(t).append(" ").append(helper() ? "yes" : "no").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}