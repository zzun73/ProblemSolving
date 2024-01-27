package baekjoon.silver.Num27648;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N + M - 1 > K) {
            sb.append("NO");
        } else {
            sb.append("YES").append("\n");
            for (int i = 0; i < N; i++) {
                int cur = i + 1;
                for (int j = 0; j < M; j++) {
                    sb.append(cur++).append(" ");
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}