package baekjoon.bronze.Num11648;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        while (N >= 10) {
            int val = 1;
            while (N > 0) {
                val *= N % 10;
                N /= 10;
            }
            N = val;
            answer++;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}