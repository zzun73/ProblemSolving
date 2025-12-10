package baekjoon.silver.Num12760;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        int[] score = new int[N];
        for (int j = M - 1; j >= 0; j--) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, arr[i][j]);
            }
            for (int i = 0; i < N; i++) {
                if (arr[i][j] == max) {
                    score[i]++;
                }
            }
        }

        int maxScore = 0;
        for (int i = 0; i < N; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }

        for (int i = 0; i < N; i++) {
            if (score[i] == maxScore) {
                sb.append(i + 1).append(" ");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}