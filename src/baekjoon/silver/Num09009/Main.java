package baekjoon.silver.Num09009;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int end = 0;
        int[] dp = new int[100];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] > 1000000000) {
                end = i;
                break;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            ArrayList<Integer> answer = new ArrayList<>();
            for (int j = end; j >= 0; j--) {
                if (n == 0) {
                    break;
                }
                if (dp[j] <= n) {
                    answer.add(dp[j]);
                    n -= dp[j];
                }
            }
            Collections.reverse(answer);
            for (Integer val : answer) {
                bw.write(val + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
