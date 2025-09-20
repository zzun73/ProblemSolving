package baekjoon.bronze.Num16546;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        long total = (long) N * (N + 1) / 2;
        long sum = 0;

        for (int i = 0; i < N - 1; i++) {
            int X = Integer.parseInt(st.nextToken());
            sum += X;
        }

        bw.write(String.valueOf(total - sum));

        br.close();
        bw.close();
    }
}