package swea.d2.Num01959;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int helper(int min, int max, int[] minArr, int[] maxArr) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= max - min; i++) {
            int cur = 0;
            for (int j = 0; j < min; j++) {
                cur += minArr[j] * maxArr[i + j];
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arrN = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arrN[i] = Integer.parseInt(st.nextToken());
            }
            int[] arrM = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                arrM[i] = Integer.parseInt(st.nextToken());
            }

            int answer;
            if (N < M) {
                answer = helper(N, M, arrN, arrM);
            } else {
                answer = helper(M, N, arrM, arrN);
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}