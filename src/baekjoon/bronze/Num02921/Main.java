package baekjoon.bronze.Num02921;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= i * 2; j++) {
                answer += j;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}