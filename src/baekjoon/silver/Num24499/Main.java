package baekjoon.silver.Num24499;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N * 2 + 2];
        int[] sum = new int[N * 2 + 2];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            arr[i + N] = arr[i];
        }

        sum[1] = arr[1];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int answer = 0;
        for (int i = 1; i < arr.length - K; i++) {
            answer = Math.max(sum[i + K] - sum[i], answer);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}