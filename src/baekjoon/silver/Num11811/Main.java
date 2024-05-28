package baekjoon.silver.Num11811;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = 0;
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                num |= cur;
            }
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}