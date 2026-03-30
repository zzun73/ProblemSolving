package baekjoon.bronze.Num33964;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int a = 0;
        int b = 0;

        for (int i = 0; i < X; i++) {
            a = a * 10 + 1;
        }

        for (int i = 0; i < Y; i++) {
            b = b * 10 + 1;
        }

        bw.write(String.valueOf(a + b));

        br.close();
        bw.close();
    }
}