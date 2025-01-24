package baekjoon.silver.Num29718;

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

        int[] arr = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[j] += Integer.parseInt(st.nextToken());
            }
        }

        int A = Integer.parseInt(br.readLine());
        int[] sum = new int[M + 1];
        for (int j = 1; j <= M; j++) {
            sum[j] = sum[j - 1] + arr[j - 1];
        }

        int answer = 0;
        for (int j = A; j <= M; j++) {
            answer = Math.max(answer, sum[j] - sum[j - A]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}