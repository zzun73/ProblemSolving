package baekjoon.bronze.Num03034;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n <= W) {
                sb.append("DA");
            } else if (n <= H) {
                sb.append("DA");
            } else if (n <= Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2))) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}