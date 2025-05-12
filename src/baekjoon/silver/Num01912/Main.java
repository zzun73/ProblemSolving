package baekjoon.silver.Num01912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dp[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}