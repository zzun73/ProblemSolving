package baekjoon.bronze.Num18406;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int left = 0;
        int right = 0;

        for (int i = 0; i < input.length / 2; i++) {
            left += input[i] - '0';
            right += input[input.length - i - 1] - '0';
        }

        bw.write(left == right ? "LUCKY" : "READY");

        br.close();
        bw.close();
    }
}