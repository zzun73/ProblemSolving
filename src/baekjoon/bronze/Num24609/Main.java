package baekjoon.bronze.Num24609;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            sum += val;
            answer = Math.min(answer, sum);
        }
        bw.write(String.valueOf(-answer));

        br.close();
        bw.close();
    }
}