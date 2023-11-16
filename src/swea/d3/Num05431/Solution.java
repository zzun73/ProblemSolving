package swea.d3.Num05431;

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
            int K = Integer.parseInt(st.nextToken());
            boolean[] student = new boolean[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < K; i++) {
                int cur = Integer.parseInt(st.nextToken());
                student[cur] = true;
            }

            sb.append("#").append(t).append(" ");
            for (int i = 1; i <= N; i++) {
                if (!student[i]) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}