package baekjoon.silver.Num14916;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                answer += N / 5;
                break;
            } else {
                answer += 1;
                N -= 2;
            }
        }
        bw.write(N < 0 ? "-1" : answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
