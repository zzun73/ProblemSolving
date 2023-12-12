package baekjoon.bronze.Num03058;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 7; i++) {
                int X = Integer.parseInt(st.nextToken());
                if (X % 2 == 0) {
                    min = Math.min(min, X);
                    sum += X;
                }
            }
            sb.append(sum).append(" ").append(min).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}