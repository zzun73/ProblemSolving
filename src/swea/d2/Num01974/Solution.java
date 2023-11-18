package swea.d2.Num01974;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    private static final int SIZE = 9;
    static int[][] board;
    static HashSet<Integer> set;

    public static boolean rowCheck() {
        for (int i = 0; i < SIZE; i++) {
            set.clear();
            for (int j = 0; j < SIZE; j++) {
                set.add(board[i][j]);
            }
            if (set.size() != SIZE) {
                return false;
            }
        }
        return true;
    }

    public static boolean colCheck() {
        for (int i = 0; i < SIZE; i++) {
            set.clear();
            for (int j = 0; j < SIZE; j++) {
                set.add(board[j][i]);
            }
            if (set.size() != SIZE) {
                return false;
            }
        }
        return true;
    }

    public static boolean boxCheck() {
        for (int i = 0; i < SIZE; i += 3) {
            for (int j = 0; j < SIZE; j += 3) {
                set.clear();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        set.add(board[k][l]);
                    }
                }
                if (set.size() != SIZE) {
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

            for (int i = 0; i < SIZE; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < SIZE; j++) {
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