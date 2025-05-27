package baekjoon.bronze.Num02857;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 5; i++) {
            String str = br.readLine();
            if (str.contains("FBI")) {
                sb.append(i).append(" ");
            }
        }

        if (sb.length() == 0) {
            sb.append("HE GOT AWAY!");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}