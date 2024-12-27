package baekjoon.bronze.Num04696;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            double n = Double.parseDouble(br.readLine());
            if (n == 0) {
                break;
            }

            double answer = 1 + n + Math.pow(n, 2) + Math.pow(n, 3) + Math.pow(n, 4);
            sb.append(String.format("%.2f", answer)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}