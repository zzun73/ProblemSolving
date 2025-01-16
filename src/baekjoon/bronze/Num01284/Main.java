package baekjoon.bronze.Num01284;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String N = br.readLine();

            if (N.equals("0")) {
                break;
            }

            int answer = 1;
            for (char ch : N.toCharArray()) {
                if (ch == '1') {
                    answer += 3;
                } else if (ch == '0') {
                    answer += 5;
                } else {
                    answer += 4;
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}