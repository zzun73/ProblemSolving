package baekjoon.bronze.Num05102;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) {
                break;
            }

            int n = a - b;
            int t = (n >= 3 && n % 2 == 1) ? 1 : 0;
            int p = (n - t * 3) / 2;

            sb.append(p).append(" ").append(t).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}