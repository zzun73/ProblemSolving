package baekjoon.bronze.Num15917;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());
            boolean isPow = X > 0 && ((X & (X - 1)) == 0);
            sb.append(isPow ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}