package baekjoon.bronze.Num24183;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = 229 * 324 * Integer.parseInt(st.nextToken()) * 2;
        int B = 297 * 420 * Integer.parseInt(st.nextToken()) * 2;
        int C = 210 * 297 * Integer.parseInt(st.nextToken());

        bw.write(String.valueOf((A + B + C) * 0.000001));

        br.close();
        bw.close();
    }
}