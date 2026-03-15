package baekjoon.bronze.Num13484;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        bw.write(String.valueOf(N * X + X - sum));

        br.close();
        bw.close();
    }
}