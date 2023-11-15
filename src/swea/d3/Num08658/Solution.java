package swea.d3.Num08658;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static final int SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < SIZE; i++) {
                int cur = Integer.parseInt(st.nextToken());
                int sum = 0;
                while (cur > 0) {
                    sum += cur % 10;
                    cur /= 10;
                }
                max = Math.max(sum, max);
                min = Math.min(sum, min);
            }
            sb.append("#").append(t).append(" ").append(max).append(" ").append(min).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}