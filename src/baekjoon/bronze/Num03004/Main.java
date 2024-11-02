package baekjoon.bronze.Num03004;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        int cur = 1;
        for (int i = 0; i < N; i++) {
            if (i % 2 != 0) {
                cur += 1;
            }
            answer += cur;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}