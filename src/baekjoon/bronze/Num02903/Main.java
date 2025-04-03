package baekjoon.bronze.Num02903;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf((int)Math.pow(Math.pow(2, N) +1, 2)));

        br.close();
        bw.close();
    }
}