package baekjoon.silver.Num05766;

import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX_SIZE = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;

            int[] score = new int[MAX_SIZE];
            if (N == 0 && M == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int idx = Integer.parseInt(st.nextToken());
                    score[idx]++;
                }
            }

            for (int i = 1; i < MAX_SIZE; i++) {
                if (score[i] > first) {
                    second = first;
                    first = score[i];
                } else if (score[i] > second && score[i] < first) {
                    second = score[i];
                }
            }

            for (int i = 1; i < MAX_SIZE; i++) {
                if (score[i] == second) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}