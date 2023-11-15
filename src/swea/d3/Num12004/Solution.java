package swea.d3.Num12004;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        boolean[] checked = new boolean[101];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                checked[i * j] = true;
            }
        }
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            sb.append("#").append(t).append(" ").append(checked[N] ? "Yes" : "No").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}