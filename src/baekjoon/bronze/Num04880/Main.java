package baekjoon.bronze.Num04880;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0 && C == 0) {
                break;
            }

            int N = B - A;
            int M = C - B;

            if (N == M) {
                sb.append("AP ").append(C + M).append("\n");
            } else {
                sb.append("GP ").append(C + (M * (M / N))).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}