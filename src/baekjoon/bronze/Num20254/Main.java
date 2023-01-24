package baekjoon.bronze.Num20254;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int Ur = Integer.parseInt(st.nextToken());
        int Tr = Integer.parseInt(st.nextToken());
        int Uo = Integer.parseInt(st.nextToken());
        int To = Integer.parseInt(st.nextToken());

        bw.write(56 * Ur + 24 * Tr + 14 * Uo + 6 * To + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
