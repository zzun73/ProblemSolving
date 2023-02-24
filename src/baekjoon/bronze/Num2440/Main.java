package baekjoon.bronze.Num2440;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            bw.write("*".repeat(N - i) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
