package swea.d3.Num07272;

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
            char[] ch1 = st.nextToken().toCharArray();
            char[] ch2 = st.nextToken().toCharArray();
            boolean flag = false;
            if (ch1.length != ch2.length) {
                flag = true;
            } else {
                for (int i = 0; i < ch1.length; i++) {
                    if ("CEFGHIJKLMNSTUVWXYZ".contains(ch1[i] + "") && "CEFGHIJKLMNSTUVWXYZ".contains(ch2[i] + "")
                            || "ADOPQR".contains(ch1[i] + "") && "ADOPQR".contains(ch2[i] + "")
                            || 'B' == ch1[i] && 'B' == ch2[i]) {
                        continue;
                    }
                    flag = true;
                    break;
                }
            }
            sb.append("#").append(t).append(" ").append(flag ? "DIFF" : "SAME").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}