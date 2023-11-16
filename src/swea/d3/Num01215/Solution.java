package swea.d3.Num01215;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            char[][] board = new char[8][8];
            for (int i = 0; i < board.length; i++) {
                String input = br.readLine();
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = input.charAt(j);
                }
            }

            int answer = 0;
            boolean flag;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length - N + 1; j++) {
                    flag = false;
                    for (int k = 0; k < N / 2; k++) {
                        if ((board[i][j + k] != board[i][j + N - k - 1])) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        continue;
                    }
                    answer++;
                }
            }

            for (int i = 0; i < board.length - N + 1; i++) {
                for (int j = 0; j < board.length; j++) {
                    flag = false;
                    for (int k = 0; k < N / 2; k++) {
                        if (board[i + k][j] != board[i + N - k - 1][j]) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        continue;
                    }
                    answer++;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}