package baekjoon.bronze.Num28352;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int val = 1;
        for (int i = 11; i <= N; i++) {
            val *= i;
        }
        bw.write(String.valueOf(6 * val));

        br.close();
        bw.flush();
        bw.close();
    }
}