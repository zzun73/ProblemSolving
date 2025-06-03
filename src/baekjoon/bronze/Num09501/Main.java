package baekjoon.bronze.Num09501;

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
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            double P = Double.parseDouble(st.nextToken());

            int answer = 0;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                double v = Double.parseDouble(st.nextToken());
                double f = Double.parseDouble(st.nextToken());
                double c = Double.parseDouble(st.nextToken());

                if ((P / v) * c <= f) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}