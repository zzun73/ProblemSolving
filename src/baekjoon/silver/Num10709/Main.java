package baekjoon.silver.Num10709;

import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static int[][] map;
    static char[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        input = new char[H + 1][W + 1];
        map = new int[H + 1][W + 1];

        for (int[] row : map) {
            Arrays.fill(row, -1);
        }

        for (int i = 1; i <= H; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 1; j <= W; j++) {
                input[i][j] = row[j - 1];
            }
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (input[i][j] == 'c') {
                    map[i][j] = 0;
                } else {
                    if (map[i][j - 1] != -1) {
                        map[i][j] = map[i][j - 1] + 1;
                    }
                }

                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}