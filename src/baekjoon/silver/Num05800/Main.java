package baekjoon.silver.Num05800;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int diff = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                diff = Math.max(diff, arr[i] - arr[i - 1]);
            }

            sb.append("Class").append(" ").append(t).append("\n");
            sb.append("Max").append(" ").append(arr[N - 1]).append(",").append(" ")
                    .append("Min").append(" ").append(arr[0]).append(",").append(" ")
                    .append("Largest").append(" ").append("gap").append(" ").append(diff).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}