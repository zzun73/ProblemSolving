package baekjoon.bronze.Num09550;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
             st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int val = Integer.parseInt(st.nextToken());
                count += val / K;
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}