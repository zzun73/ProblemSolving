package swea.d3.Num01213;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            String target = br.readLine();
            String str = br.readLine();
            String res = str.replaceAll(target, "");

            sb.append("#").append(t).append(" ").append((str.length() - res.length()) / target.length()).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}