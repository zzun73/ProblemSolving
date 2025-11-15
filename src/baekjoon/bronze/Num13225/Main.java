package baekjoon.bronze.Num13225;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int i = 1; i * i <= N; i++) {
                if (N % i == 0) {
                    cnt++;
                    if (i * i != N) {
                        cnt++;
                    }
                }
            }

            sb.append(N).append(" ").append(cnt).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}