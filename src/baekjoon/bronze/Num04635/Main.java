package baekjoon.bronze.Num04635;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == -1) {
                break;
            }

            int answer = 0, prev = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                answer += s * (t - prev);
                prev = t;
            }
            sb.append(answer).append(" miles").append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}