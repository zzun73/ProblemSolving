package baekjoon.bronze.Num28135;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i < N; i++) {
            if (String.valueOf(i).contains("50")) {
                answer++;
            }
        }

        bw.write(String.valueOf(N + answer));

        br.close();
        bw.close();
    }
}