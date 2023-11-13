package swea.d3.Num02817;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int N, K, answer;
    static int[] arr;

    public static void helper(int idx, int sum) {
        if (sum == K) {
            answer++;
            return;
        } else if (idx >= N || sum > K) {
            return;
        }

        helper(idx + 1, sum + arr[idx]);
        helper(idx + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            answer = 0;
            arr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            helper(0, 0);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}