package baekjoon.bronze.Num27541;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int len = S.length();
        if (S.charAt(len - 1) == 'G') {
            sb.append(S, 0, len - 1);
        } else {
            sb.append(S).append("G");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}