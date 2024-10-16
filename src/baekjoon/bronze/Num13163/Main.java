package baekjoon.bronze.Num13163;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append("god");
            st.nextToken();
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}