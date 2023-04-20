package baekjoon.bronze.Num21354;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()) * 7;
        int P = Integer.parseInt(st.nextToken()) * 13;

        bw.write(A > P ? "Axel" : A < P ? "Petra" : "lika");

        br.close();
        bw.flush();
        bw.close();
    }
}
