package baekjoon.gold.Num12904;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() != S.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.setLength(T.length() - 1);
            } else if (T.charAt(T.length() - 1) == 'B') {
                T.setLength(T.length() - 1);
                T.reverse();
            }
        }

        bw.write(T.toString().contentEquals(S) ? "1" : "0");

        br.close();
        bw.close();
    }
}