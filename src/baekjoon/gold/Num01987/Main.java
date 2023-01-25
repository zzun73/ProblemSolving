package baekjoon.gold.Num01987;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, answer;
    static int[][] board;
    static boolean[][] visited;
    static boolean[] checked;

    public static void helper(int depth, int xpos, int ypos) {
        if (xpos < 0 || xpos >= R || ypos < 0 || ypos >= C || visited[xpos][ypos] || checked[board[xpos][ypos]]) {
            answer = Math.max(depth, answer);
            return;
        }

        if (!visited[xpos][ypos] && !checked[board[xpos][ypos]]) {
            visited[xpos][ypos] = true;
            checked[board[xpos][ypos]] = true;
            helper(depth + 1, xpos + 1, ypos);
            helper(depth + 1, xpos - 1, ypos);
            helper(depth + 1, xpos, ypos + 1);
            helper(depth + 1, xpos, ypos - 1);
            visited[xpos][ypos] = false;
            checked[board[xpos][ypos]] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        checked = new boolean[26];
        answer = 0;
        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }

        helper(0, 0, 0);
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
