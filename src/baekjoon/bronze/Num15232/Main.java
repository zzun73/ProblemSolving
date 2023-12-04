package baekjoon.bronze.Num15232;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        while (R-- > 0) {
            sb.append("*".repeat(C)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}