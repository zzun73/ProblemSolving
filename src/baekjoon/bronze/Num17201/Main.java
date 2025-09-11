package baekjoon.bronze.Num17201;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String s = br.readLine().trim();

        bw.write((s.contains("11") || s.contains("22")) ? "No" : "Yes");

        br.close();
        bw.close();
    }
}