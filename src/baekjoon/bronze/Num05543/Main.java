package baekjoon.bronze.Num05543;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int burger = Integer.MAX_VALUE;
        int beverage = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            burger = Math.min(burger, Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < 2; i++) {
            beverage = Math.min(beverage, Integer.parseInt(br.readLine()));
        }

        bw.write(burger + beverage - 50 + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
