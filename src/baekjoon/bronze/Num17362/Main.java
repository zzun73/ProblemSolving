package baekjoon.bronze.Num17362;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        N %= 8;
        int answer = N == 0 ? 2 : N > 5 ? (10 - N) : N;
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
