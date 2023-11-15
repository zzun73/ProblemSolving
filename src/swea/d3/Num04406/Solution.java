package swea.d3.Num04406;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String[] ch = new String[]{"a", "e", "i", "o", "u"};
        for (int t = 1; t <= T; t++) {
            String cur = br.readLine();
            for (String s : ch) {
                cur = cur.replace(s, "");
            }

            sb.append("#").append(t).append(" ").append(cur).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}