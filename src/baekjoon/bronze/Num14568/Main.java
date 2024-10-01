package baekjoon.bronze.Num14568;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i < N / 2; i++) {
            for (int j = 1; N - 2 * i - 2 * j >= 2; j++) {
                answer++;
            }

        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}