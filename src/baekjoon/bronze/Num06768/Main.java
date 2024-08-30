package baekjoon.bronze.Num06768;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = ((N - 1) * (N - 2) * (N - 3)) / 6;

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}