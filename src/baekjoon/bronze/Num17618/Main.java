package baekjoon.bronze.Num17618;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            int n = i;

            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }

            if (i % sum == 0) {
                answer++;
            }

        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}