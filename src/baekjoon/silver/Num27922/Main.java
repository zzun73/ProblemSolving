package baekjoon.silver.Num27922;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] ab = new int[N];
        int[] ac = new int[N];
        int[] bc = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ab[i] = a + b;
            ac[i] = a + c;
            bc[i] = b + c;
        }

        Arrays.sort(ab);
        Arrays.sort(ac);
        Arrays.sort(bc);

        long sumAB = 0;
        long sumAC = 0;
        long sumBC = 0;

        for (int i = N - 1; i >= N - K; i--) {
            sumAB += ab[i];
            sumAC += ac[i];
            sumBC += bc[i];
        }

        long answer = Math.max(sumAB, Math.max(sumAC, sumBC));

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}