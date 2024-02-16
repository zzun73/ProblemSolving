package baekjoon.gold.Num09660;

import java.io.*;

public class Main {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Long.parseLong(br.readLine());
        bw.write(N % 7 == 0 || N % 7 == 2 ? "CY" : "SK");

        br.close();
        bw.close();
    }
}