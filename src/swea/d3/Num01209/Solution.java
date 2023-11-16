package swea.d3.Num01209;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static final int SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            br.readLine();

            int[][] arr = new int[SIZE][SIZE];
            int rowMax, colMax, diagonalMax;
            rowMax = colMax = Integer.MIN_VALUE;
            for (int i = 0; i < SIZE; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int rowSum = 0;
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    rowSum += arr[i][j];
                }
                rowMax = Math.max(rowMax, rowSum);
            }

            for (int j = 0; j < SIZE; j++) {
                int colSum = 0;
                for (int i = 0; i < SIZE; i++) {
                    colSum += arr[i][j];
                }
                colMax = Math.max(colMax, colSum);
            }

            int leftDiagonalSum = 0, rightDiagonalSum = 0;
            for (int i = 0; i < SIZE; i++) {
                leftDiagonalSum += arr[i][i];
                rightDiagonalSum += arr[i][SIZE - i - 1];
            }
            diagonalMax = Math.max(leftDiagonalSum, rightDiagonalSum);

            sb.append("#").append(t).append(" ").append(Math.max(Math.max(rowMax, colMax), diagonalMax)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}