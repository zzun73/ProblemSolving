package baekjoon.bronze.Num26307;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int HH = Integer.parseInt(st.nextToken());
        int MM = Integer.parseInt(st.nextToken());

        bw.write((HH - 9) * 60 + MM + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
