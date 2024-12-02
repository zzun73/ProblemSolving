package baekjoon.bronze.Num02985;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A + B == C) {
            sb.append(A).append("+").append(B).append("=").append(C);
        } else if (A - B == C) {
            sb.append(A).append("-").append(B).append("=").append(C);
        } else if (A * B == C) {
            sb.append(A).append("*").append(B).append("=").append(C);
        } else if (A / B == C) {
            sb.append(A).append("/").append(B).append("=").append(C);
        } else if (A == B + C) {
            sb.append(A).append("=").append(B).append("+").append(C);
        } else if (A == B - C) {
            sb.append(A).append("=").append(B).append("-").append(C);
        } else if (A == B * C) {
            sb.append(A).append("=").append(B).append("*").append(C);
        } else if (A == B / C) {
            sb.append(A).append("=").append(B).append("/").append(C);
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}