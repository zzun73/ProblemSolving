package baekjoon.silver.Num14501;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[17][2];
        int[] dp = new int[17];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr[i][0] = T;
            arr[i][1] = P;
        }

        int answer = 0;
        for (int i = 1; i <= N + 1; i++) {
            dp[i] = Math.max(dp[i], answer);
            if (arr[i][0] + i <= N + 1) {
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
            }
            answer = Math.max(dp[i], answer);
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
