package baekjoon.silver.Num04158;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(br.readLine());
            }

            int i = 0, j = 0, answer = 0;

            while (i < N && j < M) {
                if (A[i] == B[j]) {
                    answer++;
                    i++;
                    j++;
                } else if (A[i] < B[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}