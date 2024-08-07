package baekjoon.bronze.Num05724;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int sum = 0;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            for (int i = 1; i <= N; i++) {
                sum += i * i;
            }
            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}