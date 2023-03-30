package baekjoon.bronze.Num21612;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int B = Integer.parseInt(br.readLine());
        int P = 5 * B - 400;

        bw.write(P + "\n");
        bw.write(P < 100 ? "1" : (P == 100) ? "0" : "-1");

        br.close();
        bw.flush();
        bw.close();
    }
}
