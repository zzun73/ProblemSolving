package baekjoon.bronze.Num15295;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            long N = Long.parseLong(st.nextToken());

            long candles = N * (N + 3) / 2;
            sb.append(K).append(" ").append(candles).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}