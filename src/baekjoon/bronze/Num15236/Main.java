package baekjoon.bronze.Num15236;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        long answer = (N + 2) * N * (N + 1) / 2;

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}