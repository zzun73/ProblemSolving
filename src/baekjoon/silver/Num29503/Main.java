package baekjoon.silver.Num29503;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int L = Integer.MIN_VALUE;
        int R = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            L = Math.max(L, X - D);
            R = Math.min(R, X + D);
        }
        if (L > R) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(R));
        }

        br.close();
        bw.close();
    }
}