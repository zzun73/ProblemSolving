package baekjoon.bronze.Num24072;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(c < a || b <= c ? 0 : 1));

        br.close();
        bw.close();
    }
}