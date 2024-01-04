package baekjoon.bronze.Num24264;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long N = Integer.parseInt(br.readLine());
        sb.append(N * N).append("\n").append(2);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}