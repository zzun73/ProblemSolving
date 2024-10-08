package baekjoon.bronze.Num11134;

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
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (N % C == 0) {
                sb.append(N / C).append("\n");
            } else {
                sb.append((N / C) + 1).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}