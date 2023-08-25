package baekjoon.silver.Num09656;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(N % 2 == 0 ? "SK" : "CY");

        br.close();
        bw.flush();
        bw.close();
    }
}
