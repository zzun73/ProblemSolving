package baekjoon.silver.Num01343;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char ch : input) {
            if (ch == 'X') {
                count++;
                if (count == 4) {
                    sb.append("AAAA");
                    count = 0;
                }
            } else {
                if (count == 2) {
                    sb.append("BB");
                    sb.append(".");
                    count = 0;
                } else if (count != 0) {
                    sb.setLength(0);
                    break;
                } else {
                    sb.append(".");
                }
            }
        }
        if (count == 2) {
            sb.append("BB");
        } else if (count != 0) {
            sb.setLength(0);
        }

        bw.write(sb.length() == 0 ? "-1" : sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
