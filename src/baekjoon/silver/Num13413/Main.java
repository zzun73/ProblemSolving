package baekjoon.silver.Num13413;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();
            int black = 0;
            int white = 0;

            while (N-- > 0) {
                if (a[N] != b[N]) {
                    if (b[N] == 'B') {
                        black++;
                    } else {
                        white++;
                    }
                }
            }
            sb.append(Math.max(black, white)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
