package baekjoon.bronze.Num11319;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String input = br.readLine().replaceAll(" ", "").toLowerCase();
            int len = input.length();
            String cur = input.replaceAll("[aeiou]", "");

            sb.append(cur.length()).append(" ").append(len - cur.length()).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}