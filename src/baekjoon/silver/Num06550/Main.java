package baekjoon.silver.Num06550;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            String[] str = input.split(" ");
            char[] s = str[0].toCharArray();
            char[] t = str[1].toCharArray();

            int count = 0, index = 0;
            for (int i = 0; i < t.length; i++) {
                if (count == s.length) {
                    break;
                }
                if (s[index] == t[i]) {
                    count++;
                    index++;
                }
            }
            sb.append(count == s.length ? "Yes" : "No").append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}