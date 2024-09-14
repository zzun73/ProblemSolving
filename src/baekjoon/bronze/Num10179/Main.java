package baekjoon.bronze.Num10179;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            double money = Double.parseDouble(br.readLine());
            money *= 0.8;
            sb.append("$").append(String.format("%.2f", money)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}