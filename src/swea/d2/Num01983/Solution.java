package swea.d2.Num01983;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String[] grade = new String[]{"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Double> score = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                double cur = (a * 0.35 + b * 0.45 + c * 0.20);
                score.add(cur);
            }
            Double target = score.get(K - 1);
            score.sort(Collections.reverseOrder());

            int value = N / 10;
            int idx = score.indexOf(target) / value;
            sb.append("#").append(t).append(" ").append(grade[idx]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}