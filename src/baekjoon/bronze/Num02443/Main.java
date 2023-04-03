package baekjoon.bronze.Num02443;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = N; i > 0; i--) {
            for (int j = i; j < N; j++) {
                bw.write(" ");
            }
            for (int k = 1; k <= i * 2 - 1; k++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
