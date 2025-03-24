package baekjoon.bronze.Num11282;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()) + 44031;

        bw.write(String.valueOf((char) N));

        br.close();
        bw.close();
    }
}