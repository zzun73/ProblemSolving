package baekjoon.silver.Num09095;

import java.io.*;

public class Main {
    static int T, N, answer;

    static void helper(int sum) {
        if (sum == N) {
            answer++;
            return;
        }
        if (sum > N) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            helper(sum + i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            helper(0);
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}
