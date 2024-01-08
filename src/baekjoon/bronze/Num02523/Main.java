package baekjoon.bronze.Num02523;

import java.io.*;

public class Main {
    private static final String STAR = "*";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append(STAR.repeat(i)).append("\n");
        }
        for (int i = N - 1; i > 0; i--) {
            sb.append(STAR.repeat(i)).append("\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}