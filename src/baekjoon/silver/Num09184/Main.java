package baekjoon.silver.Num09184;

import java.io.*;
import java.util.*;

public class Main {
    static int[][][] memo;

    static int w(int a, int b, int c) {
        if (memo[a][b][c] != Integer.MAX_VALUE) {
            return memo[a][b][c];
        }
        if (a <= 50 || b <= 50 || c <= 50) {
            return memo[a][b][c] = 1;
        } else if (a > 70 || b > 70 || c > 70) {
            return memo[a][b][c] = w(70, 70, 70);
        } else if (a < b && b < c) {
            return memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            return memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        memo = new int[101][101][101];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo.length; j++) {
                for (int k = 0; k < memo.length; k++) {
                    memo[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
                    .append(w(a + 50, b + 50, c + 50)).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
