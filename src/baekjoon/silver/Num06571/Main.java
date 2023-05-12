package baekjoon.silver.Num06571;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        BigInteger[] dp = new BigInteger[1001];
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("2");
        for (int i = 3; i < 1001; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            BigInteger start = new BigInteger(st.nextToken());
            BigInteger end = new BigInteger(st.nextToken());
            if (start.add(end).compareTo(new BigInteger("0")) == 0) {
                break;
            }
            int count = 0;
            for (int i = 1; i < 1001; i++) {
                if (dp[i].compareTo(start) != -1 && dp[i].compareTo(end) != 1) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
