package swea.d3.Num05603;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];
            }
            sum /= N;

            int answer = 0;
            for (int val : arr) {
                if (val > sum) {
                    answer += val - sum;
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