package baekjoon.bronze.Num32651;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (N <= 100000 && N % 2024 == 0) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }

        br.close();
        bw.close();
    }
}