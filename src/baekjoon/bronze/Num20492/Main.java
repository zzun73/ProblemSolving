package baekjoon.bronze.Num20492;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write((int) (N * 0.78) + "\n" + (int) (N - (N * 0.2 * 0.22)));

        br.close();
        bw.flush();
        bw.close();
    }
}