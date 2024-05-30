package baekjoon.bronze.Num27890;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            if (X % 2 == 0) {
                X = (X / 2) ^ 6;
            } else {
                X = (2 * X) ^ 6;
            }
        }

        bw.write(String.valueOf(X));
        br.close();
        bw.close();
    }
}