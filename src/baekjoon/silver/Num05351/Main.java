package baekjoon.silver.Num05351;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int len = 0;
            while (st.hasMoreTokens()) {
                st.nextToken();
                len++;
            }

            int[] coin = new int[len];
            st = new StringTokenizer(str, " ");
            for (int i = 0; i < len; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[len];
            if (len > 0) {
                dp[0] = coin[0];
            }
            if (len > 1) {
                dp[1] = Math.max(coin[0], coin[1]);
            }
            for (int i = 2; i < len; i++) {
                dp[i] = Math.max(dp[i - 2] + coin[i], dp[i - 1]);
            }
            bw.write(dp[len - 1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
