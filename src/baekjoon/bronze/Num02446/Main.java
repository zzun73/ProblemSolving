package baekjoon.bronze.Num02446;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            sb.append(" ".repeat(i - 1));
            sb.append("*".repeat((N - i + 1) * 2 - 1));
            sb.append("\n");
        }

        for (int i = N; i > 0; i--) {
            sb.append(" ".repeat(i - 1));
            sb.append("*".repeat((N - i + 1) * 2 - 1));
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
