package baekjoon.bronze.Num32661;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int min = 100000, max = 0;

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        bw.write(String.valueOf(Math.max(0, min - max / 2)));

        br.close();
        bw.close();
    }
}