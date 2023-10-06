package baekjoon.silver.Num01531;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[101][101];
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    arr[i][j]++;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] > M) {
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}