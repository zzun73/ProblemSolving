package baekjoon.bronze.Num02914;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(A * (I - 1) + 1));

        br.close();
        bw.close();
    }
}