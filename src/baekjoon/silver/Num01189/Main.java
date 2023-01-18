package baekjoon.silver.Num01189;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K;
    static char[][] board;
    static int answer;

    public static void helper(int depth, int xpos, int ypos) {
        if (depth > K || xpos >= R || xpos < 0 || ypos >= C || ypos < 0 || board[xpos][ypos] == 'T' || board[xpos][ypos] == 'V') {
            return;
        }
        if (xpos == 0 && ypos == C - 1) {
            if (depth == K) {
                answer++;
            }
            return;
        }

        if (board[xpos][ypos] == '.') {
            board[xpos][ypos] = 'V';
            helper(depth + 1, xpos + 1, ypos);
            helper(depth + 1, xpos - 1, ypos);
            helper(depth + 1, xpos, ypos + 1);
            helper(depth + 1, xpos, ypos - 1);
            board[xpos][ypos] = '.';
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = 0;
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        helper(1, R - 1, 0);
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
