package baekjoon.bronze.Num14920;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        while (true) {
            answer++;
            if (N == 1) {
                break;
            }

            if (N % 2 == 1) {
                N = N * 3 + 1;
            } else {
                N /= 2;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}