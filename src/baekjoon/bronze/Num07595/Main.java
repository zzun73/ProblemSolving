package baekjoon.bronze.Num07595;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 1; i <= N; i++) {
                String line = "*".repeat(i);
                bw.write(line + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
