package swea.d3.Num06730;

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
            int N = Integer.parseInt(br.readLine());
            int upDiff = 0;
            int downDiff = 0;

            st = new StringTokenizer(br.readLine(), " ");
            int prev = Integer.parseInt(st.nextToken());
            for (int i = 1; i < N; i++) {
                int next = Integer.parseInt(st.nextToken());
                if (prev > next) {
                    downDiff = Math.max(prev - next, downDiff);
                } else if (prev < next) {
                    upDiff = Math.max(next - prev, upDiff);
                }
                prev = next;
            }

            sb.append("#").append(t).append(" ").append(upDiff).append(" ").append(downDiff).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}