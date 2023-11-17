package swea.d2.Num02007;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            int endIndex = 0;

            while (true) {
                String temp = str;
                String cur = str.substring(0, ++endIndex);
                temp = temp.replaceAll(cur, "");
                if (temp.equals("") || (cur.contains(temp) && temp.length() < cur.length())) {
                    break;
                }
            }
            sb.append("#").append(t).append(" ");
            sb.append(endIndex).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}