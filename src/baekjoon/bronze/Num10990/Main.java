package baekjoon.bronze.Num10990;

import java.io.*;

public class Main {
    private static final String STAR = "*";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(SPACE.repeat(N - 1)).append(STAR).append("\n");
        for (int i = 2; i <= N; i++) {
            sb.append(SPACE.repeat(N - i)).append(STAR).append(SPACE.repeat(2 * (i - 1) - 1)).append(STAR).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}