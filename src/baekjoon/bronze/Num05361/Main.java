package baekjoon.bronze.Num05361;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double A = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());
            double C = Double.parseDouble(st.nextToken());
            double D = Double.parseDouble(st.nextToken());
            double E = Double.parseDouble(st.nextToken());

            double result = (A * 350.34) + (B * 230.90) + (C * 190.55) + (D * 125.30) + (E * 180.90);

            sb.append("$").append(String.format("%.2f", result)).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}