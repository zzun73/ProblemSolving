package baekjoon.bronze.Num31628;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String[][] board = new String[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 10; j++) {
                board[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < 10; i++) {
            boolean row = true;
            boolean col = true;

            for (int j = 1; j < 10; j++) {
                if (!board[i][0].equals(board[i][j])) {
                    row = false;
                }
                if (!board[0][i].equals(board[j][i])) {
                    col = false;
                }
            }

            if (row || col) {
                bw.write("1");
                bw.close();
                return;
            }
        }
        bw.write("0");

        br.close();
        bw.close();
    }
}