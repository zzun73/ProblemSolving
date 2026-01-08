package baekjoon.bronze.Num03985;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] cake = new int[L + 1];
        int[] expect = new int[N + 1];
        int[] actual = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            expect[i] = E - S + 1;

            for (int j = S; j <= E; j++) {
                if (cake[j] == 0) {
                    cake[j] = i;
                    actual[i]++;
                }
            }
        }

        int maxExpect = 0;
        int maxActual = 0;
        int maxExpectNum = 0;
        int maxActualNum = 0;
        for (int i = 1; i <= N; i++) {
            if (maxExpect < expect[i]) {
                maxExpect = expect[i];
                maxExpectNum = i;
            }
            if (maxActual < actual[i]) {
                maxActual = actual[i];
                maxActualNum = i;
            }
        }
        sb.append(maxExpectNum).append("\n").append(maxActualNum);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}