package swea.d2.Num01979;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                int rowCount = 0;
                for (int j = 0; j < N; j++) {

                    if (arr[i][j] == 1) {
                        rowCount++;
                    } else {
                        rowCount = 0;
                    }
                    if (rowCount == K && (j == N - 1 || arr[i][j + 1] == 0)) {
                        answer++;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                int colCount = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 1) {
                        colCount++;
                    } else {
                        colCount = 0;
                    }
                    if (colCount == K && (i == N - 1 || arr[i+1][j] == 0)) {
                        answer++;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}