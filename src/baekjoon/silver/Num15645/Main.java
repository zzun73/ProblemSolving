package baekjoon.silver.Num15645;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            if (i == 0) {
                dpMin[0][0] = dpMax[0][0] = first;
                dpMin[0][1] = dpMax[0][1] = second;
                dpMin[0][2] = dpMax[0][2] = third;
            } else {
                dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + first;
                dpMax[i][1] = Math.max(Math.max(dpMax[i - 1][0], dpMax[i - 1][1]), dpMax[i - 1][2]) + second;
                dpMax[i][2] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + third;

                dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + first;
                dpMin[i][1] = Math.min(Math.min(dpMin[i - 1][0], dpMin[i - 1][1]), dpMin[i - 1][2]) + second;
                dpMin[i][2] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + third;
            }

        }
        int maxValue = Math.max(Math.max(dpMax[N - 1][0], dpMax[N - 1][1]), dpMax[N - 1][2]);
        int minValue = Math.min(Math.min(dpMin[N - 1][0], dpMin[N - 1][1]), dpMin[N - 1][2]);

        sb.append(maxValue).append(" ").append(minValue);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
