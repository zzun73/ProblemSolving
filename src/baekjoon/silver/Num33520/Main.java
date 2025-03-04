package baekjoon.silver.Num33520;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long maxW = 0;
        long maxH = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int w = Math.min(a, b);
            int h = Math.max(a, b);

            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        bw.write(String.valueOf(maxW * maxH));

        br.close();
        bw.close();
    }
}