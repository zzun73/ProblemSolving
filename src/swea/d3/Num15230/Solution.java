package swea.d3.Num15230;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            char[] input = br.readLine().toCharArray();
            int answer = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == alphabet[i]) {
                    answer++;
                } else {
                    break;
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}