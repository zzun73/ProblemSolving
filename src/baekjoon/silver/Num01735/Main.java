package baekjoon.silver.Num01735;

import java.io.*;
import java.util.*;

public class Main {
    private static int calcGcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int E = (A * D) + (B * C);
        int F = B * D;

        int gcd = calcGcd(E, F);

        StringBuilder sb = new StringBuilder();
        sb.append(E / gcd).append(" ").append(F / gcd);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
