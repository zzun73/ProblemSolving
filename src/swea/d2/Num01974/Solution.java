package swea.d2.Num01974;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    private static final int BOARD_SIZE = 9;
    private static final int BOX_SIZE = 3;
    static int[][] board;
    static HashSet<Integer> set;

    static boolean rowCheck() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            set.clear();
            for (int j = 0; j < BOARD_SIZE; j++) {
                set.add(board[i][j]);
            }
            if (set.size() != BOARD_SIZE) {
                return false;
            }
        }
        return true;
    }

    static boolean colCheck() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            set.clear();
            for (int j = 0; j < BOARD_SIZE; j++) {
                set.add(board[j][i]);
            }
            if (set.size() != BOARD_SIZE) {
                return false;
            }
        }
        return true;
    }

    static boolean boxCheck() {
        for (int i = 0; i < BOARD_SIZE; i += BOX_SIZE) {
            for (int j = 0; j < BOARD_SIZE; j += BOX_SIZE) {
                set.clear();
                for (int k = i; k < i + BOX_SIZE; k++) {
                    for (int l = j; l < j + BOX_SIZE; l++) {
                        set.add(board[k][l]);
                    }
                }
                if (set.size() != BOARD_SIZE) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            board = new int[9][9];
            set = new HashSet<>();

            for (int i = 0; i < BOARD_SIZE; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < BOARD_SIZE; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(t).append(" ");
            if (rowCheck() && colCheck() && boxCheck()) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}