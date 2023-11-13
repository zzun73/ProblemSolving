package swea.d3.Num07102;

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
            int[] count = new int[N * M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    count[i + j]++;
                }
            }
            int max = 0;
            for (int i = 1; i < count.length; i++) {
                if (count[i] > count[i - 1]) {
                    max = count[i];
                }
            }

            sb.append("#").append(t).append(" ");
            for (int i = 1; i < count.length; i++) {
                if (max == count[i]) {
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