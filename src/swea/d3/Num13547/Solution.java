package swea.d3.Num13547;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] input = br.readLine().toCharArray();
            int count = 0;
            for (char c : input) {
                if (c == 'x') {
                    count++;
                }
            }
            sb.append("#").append(t).append(" ").append(count > 7 ? "NO" : "YES").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}