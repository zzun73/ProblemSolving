package baekjoon.bronze.Num11005;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(N, B).toUpperCase());

        br.close();
        bw.flush();
        bw.close();
    }
}