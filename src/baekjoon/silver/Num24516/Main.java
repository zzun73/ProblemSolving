package baekjoon.silver.Num24516;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 2 * N - 1; i += 2) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}