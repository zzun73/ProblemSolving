package baekjoon.gold.Num09663;

import java.io.*;

public class Main {
    static int N;
    static int[] board;
    static int answer;

    static void helper(int depth) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;

            if (isPossible(depth)) {
                helper(depth + 1);
            }
        }
    }

    static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (board[col] == board[i] || (Math.abs(col - i) == Math.abs(board[col] - board[i]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[15];
        answer = 0;

        helper(0);
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}