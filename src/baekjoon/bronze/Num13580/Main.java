package baekjoon.bronze.Num13580;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A == B || A == C || B == C) {
            bw.write("S");
        } else if (A + B == C || A + C == B || B + C == A) {
            bw.write("S");
        } else {
            bw.write("N");
        }

        br.close();
        bw.close();
    }
}