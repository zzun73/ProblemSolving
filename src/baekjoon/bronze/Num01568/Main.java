package baekjoon.bronze.Num01568;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = 1;
        int answer = 0;
        while (N > 0) {
            if (N < K)
                K = 1;
            N -= K;
            answer++;
            K++;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}