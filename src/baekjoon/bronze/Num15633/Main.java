package baekjoon.bronze.Num15633;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += i;
                if (i != n / i) {
                    count += n / i;
                }
            }
        }
        count = count * 5 - 24;

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}