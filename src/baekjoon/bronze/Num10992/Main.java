package baekjoon.bronze.Num10992;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = N; j > i; j--) {
                sb.append(" ");
            }

            if (i == N) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    sb.append("*");
                }
            } else {
                for (int j = 0; j < 2 * i - 1; j++) {
                    if (j == 0 || j == 2 * i - 1 - 1) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}