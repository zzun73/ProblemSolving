package baekjoon.bronze.Num09713;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int val = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i = 1; i <= val; i++) {
                if (i % 2 == 1) {
                    sum += i;
                }
            }
            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}