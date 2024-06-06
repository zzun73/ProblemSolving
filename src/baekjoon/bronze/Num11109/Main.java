package baekjoon.bronze.Num11109;

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
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if ((n * s) < ((n * p) + d)) {
                sb.append("do not parallelize").append("\n");
            } else if ((n * s) == ((n * p) + d)) {
                sb.append("does not matter").append("\n");
            } else {
                sb.append("parallelize").append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}