package baekjoon.bronze.Num10995;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if ((i % 2) == 1) {
                for (int j = 1; j <= N * 2; j++) {
                    if ((j % 2) == 1) {
                        bw.write("*");
                    } else {
                        bw.write(" ");
                    }
                }
            } else {
                for (int j = 1; j <= N * 2; j++) {
                    if ((j % 2) == 1) {
                        bw.write(" ");
                    } else {
                        bw.write("*");
                    }
                }
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

