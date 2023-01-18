package baekjoon.bronze.Num05341;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            bw.write(N * (N + 1) / 2 + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
