package baekjoon.bronze.Num10798;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[][] input = new char[5][15];
        int maxLength = 0;
        for (int i = 0; i < input.length; i++) {
            String str = br.readLine();
            maxLength = Math.max(maxLength, str.length());
            for (int j = 0; j < str.length(); j++) {
                input[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (char[] ch : input) {
                if (ch[i] == '\0') {
                    continue;
                }
                sb.append(ch[i]);
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}