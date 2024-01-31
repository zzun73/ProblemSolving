package baekjoon.silver.Num01436;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 1, number = 666;

        while (count != N) {
            number++;
            String cur = String.valueOf(number);
            if (cur.contains("666")) {
                count++;
            }
        }

        bw.write(String.valueOf(number));
        br.close();
        bw.close();
    }
}