package baekjoon.silver.Num17276;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int n, d; // n은 홀수, d는 45의 배수(0~360)

    static void rotate45() {

        while (d-- > 0) {
            int[][] tempMap = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tempMap[i][j] = map[i][j];
                }
            }

            // 1. 가운데 열 = 주 대각선
            for (int i = 0; i < n; i++) {
                tempMap[i][n / 2] = map[i][i];
            }

            // 2. 부 대각선 = 가운데 열
            for (int i = 0; i < n; i++) {
                tempMap[n - i - 1][i] = map[n - 1 - i][n / 2];

            }

            // 3. 가운데 행 = 부 대각선
            for (int i = 0; i < n; i++) {
                tempMap[n / 2][i] = map[n - i - 1][i];
            }

            // 4. 주 대각선 = 가운데 행
            for (int i = 0; i < n; i++) {
                tempMap[i][i] = map[n / 2][i];
            }
            map = tempMap;
        }

    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            d = ((d + 360) % 360) / 45;

            rotate45();
            for (int[] row : map) {
                for (int val : row) {
                    sb.append(val).append(" ");
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}