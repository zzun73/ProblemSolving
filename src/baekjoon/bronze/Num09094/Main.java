package baekjoon.bronze.Num09094;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int i = 1; i < N; i++) {
                for (int j = (i + 1); j < N; j++) {
                    if (((i * i) + (j * j) + M) % (i * j) == 0) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}