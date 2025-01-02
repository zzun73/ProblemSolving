package baekjoon.bronze.Num01297;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");
        double D = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());

        double pow = Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2));
        double sqrt = Math.sqrt(pow);

        sb.append((int) (sqrt * H)).append(" ").append((int) (sqrt * W));
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}