package baekjoon.silver.Num11561;

import java.io.*;

public class Main {
    static long N;

    static boolean isPossible(long value) {
        return (value * (value + 1)) / 2 <= N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Long.parseLong(br.readLine());

            long start = 0;
            long end = (long) Math.sqrt(2 * N);
            long answer = 0;
            while (start <= end) {
                long mid = (start + end) / 2;
                if (isPossible(mid)) {
                    answer = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}