package baekjoon.bronze.Num15700;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long answer = N * M / 2;

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
