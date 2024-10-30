package baekjoon.bronze.Num17614;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N + 1; i++) {
            int cur = i;
            while (cur != 0) {
                if (cur % 10 == 3 || cur % 10 == 6 || cur % 10 == 9) {
                    answer++;
                }
                cur = cur / 10;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}