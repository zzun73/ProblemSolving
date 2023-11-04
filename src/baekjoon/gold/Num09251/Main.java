package baekjoon.gold.Num09251;

import java.io.*;
import java.util.Arrays;

public class Main {
    static char[] A, B;
    static int[][] memo;

    public static int helper(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (A[i] == B[j]) {
            return memo[i][j] = 1 + helper(i - 1, j - 1);
        } else {
            return memo[i][j] = Math.max(helper(i - 1, j), helper(i, j - 1));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        memo = new int[A.length][B.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int answer = helper(A.length - 1, B.length - 1);
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}