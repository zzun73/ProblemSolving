package baekjoon.bronze.Num13136;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long rn = R % N == 0 ? R / N : R / N + 1;
        long rc = C % N == 0 ? C / N : C / N + 1;

        bw.write(String.valueOf(rn * rc));

        br.close();
        bw.flush();
        bw.close();
    }
}
