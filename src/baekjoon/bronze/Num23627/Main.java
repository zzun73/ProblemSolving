package baekjoon.bronze.Num23627;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(br.readLine().endsWith("driip") ? "cute" : "not cute");

        br.close();
        bw.close();
    }
}