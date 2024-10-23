package baekjoon.bronze.Num10991;

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
            for (int j = 0; j < 2 * i - 1; j++) {
                if (j % 2 == 0) {
                    sb.append("*");
                }
                if (j % 2 == 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}