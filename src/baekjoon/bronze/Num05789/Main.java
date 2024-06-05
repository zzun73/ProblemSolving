package baekjoon.bronze.Num05789;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String str = br.readLine();
            sb.append(str.charAt(str.length() / 2 - 1) == str.charAt(str.length() / 2) ? "Do-it" : "Do-it-Not").append('\n');
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}