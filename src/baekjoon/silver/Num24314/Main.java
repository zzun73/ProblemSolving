package baekjoon.silver.Num24314;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        bw.write(String.valueOf((c * n0 <= a1 * n0 + a0) && (c <= a1) ? 1 : 0));
        br.close();
        bw.close();
    }
}