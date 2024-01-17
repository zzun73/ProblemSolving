package baekjoon.silver.Num03085;

import java.io.*;

public class Main {
    static int N;
    static char[][] board;

    static void swap(int i, int j, int nx, int ny) {
        char temp = board[i][j];
        board[i][j] = board[nx][ny];
        board[nx][ny] = temp;
    }

    static int rowCheck() {
        int res = 0;
        for (int l = 0; l < N; l++) {
            int cur = 1;
            for (int m = 0; m < N - 1; m++) {
                if (board[l][m] == board[l][m + 1]) {
                    cur++;
                } else {
                    cur = 1;
                }
                res = Math.max(res, cur);

            }
        }
        return res;
    }

    static int colCheck() {
        int res = 0;
        for (int l = 0; l < N; l++) {
            int cur = 1;
            for (int m = 0; m < N - 1; m++) {
                if (board[m][l] == board[m + 1][l]) {
                    cur++;
                } else {
                    cur = 1;
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                board[i][j] = row[j];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                answer = Math.max(rowCheck(), answer);
                answer = Math.max(colCheck(), answer);
                swap(i, j, i, j + 1);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                answer = Math.max(rowCheck(), answer);
                answer = Math.max(colCheck(), answer);
                swap(i, j, i + 1, j);

            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }


}
