package baekjoon.bronze.Num06845;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int date = y * 10000 + m * 100 + d;
            sb.append(date <= 19890227 ? "Yes" : "No").append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}