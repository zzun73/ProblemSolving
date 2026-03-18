package baekjoon.bronze.Num04504;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (true) {
            int val = Integer.parseInt(br.readLine());
            if (val == 0) {
                break;
            }

            if (val % N != 0 ) {
                sb.append(val).append(" is NOT a multiple of ").append(N).append(".").append("\n");
            } else {
                sb.append(val).append(" is a multiple of ").append(N).append(".").append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}