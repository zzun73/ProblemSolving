package baekjoon.bronze.Num32652;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        sb.append("AKARAKA");

        while (--K > 0) {
            sb.append("RAKA");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}