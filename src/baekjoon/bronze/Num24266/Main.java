package baekjoon.bronze.Num24266;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());

        sb.append(N * N * N).append("\n").append(3);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}