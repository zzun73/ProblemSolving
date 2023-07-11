package baekjoon.bronze.Num05928;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start = (11 * 24 * 60) + (11 * 60) + 11;
        int answer = ((D * 24 * 60) + (H * 60) + M) - start;
        bw.write((answer >= 0 ? answer + "" : -1 + ""));

        br.close();
        bw.flush();
        bw.close();
    }
}
