package baekjoon.bronze.Num08760;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int Z = Integer.parseInt(br.readLine());

        while (Z-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            bw.write(W * K / 2 + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
