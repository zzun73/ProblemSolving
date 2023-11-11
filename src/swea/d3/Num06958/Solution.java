package swea.d3.Num06958;

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
            int M = Integer.parseInt(st.nextToken());
            int[] count = new int[N];
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    sum += val;
                }
                count[i] = sum;
                maxValue = Math.max(maxValue, sum);
            }

            int people = 0;
            for (int curVal : count) {
                if (curVal == maxValue) {
                    people++;
                }
            }
            sb.append("#").append(t).append(" ").append(people).append(" ").append(maxValue).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}