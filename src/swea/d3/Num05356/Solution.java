package swea.d3.Num05356;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int maxLength = 0;
            String[] str = new String[5];
            for (int i = 0; i < str.length; i++) {
                str[i] = br.readLine();
                maxLength = Math.max(str[i].length(), maxLength);
            }

            sb.append("#").append(t).append(" ");
            int idx = -1;
            while (idx++ < maxLength) {
                for (String cur : str) {
                    if (idx < cur.length()) {
                        sb.append(cur.charAt(idx));
                    }
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