package baekjoon.bronze.Num10180;

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


        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int answer = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int v = Integer.parseInt(st.nextToken());
                int f = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (v * f / c >= D) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}