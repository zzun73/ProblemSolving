package baekjoon.bronze.Num27433;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long answer = 1;
        for (int i = 1; i <= N; i++) {
            answer *= i;
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
