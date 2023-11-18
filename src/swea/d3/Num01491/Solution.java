package swea.d3.Num01491;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            long answer = Long.MAX_VALUE;
            for (long R = 1; R <= Math.sqrt(N); R++) {
                for (long C = R; C * R <= N; C++) {
                    answer = Math.min(answer, A * Math.abs(R - C) + B * (N - R * C));
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}