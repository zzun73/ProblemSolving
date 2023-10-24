package baekjoon.silver.Num01748;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int len = 1;
        int val = 10;

        for (int i = 1; i <= N; i++) {
            if (i % val == 0) {
                len++;
                val *= 10;
            }
            answer += len;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}