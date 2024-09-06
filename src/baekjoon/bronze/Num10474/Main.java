package baekjoon.bronze.Num10474;

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

            if (A == 0 && B == 0) {
                break;
            }

            sb.append((A / B)).append(" ").append(A % B).append(" / ").append(B).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}