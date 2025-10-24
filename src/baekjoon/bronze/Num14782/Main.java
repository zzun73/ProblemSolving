package baekjoon.bronze.Num14782;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                answer += i;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}