package baekjoon.silver.Num09659;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        bw.write((N % 2) == 1 ? "SK" : "CY");

        br.close();
        bw.flush();
        bw.close();
    }
}