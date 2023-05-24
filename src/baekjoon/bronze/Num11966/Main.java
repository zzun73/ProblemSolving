package baekjoon.bronze.Num11966;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int value = 1;
        while (true) {
            if (value == N) {
                bw.write("1");
                break;
            }
            if (value > N) {
                bw.write("0");
                break;
            }
            value *= 2;
        }
        br.close();
        bw.flush();
        bw.close();
    }
}