package baekjoon.bronze.Num28239;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long m = Long.parseLong(br.readLine());
            int x = 0, y = 0;
            long cur = 1;
            if ((m & 1) == 1) {
                m -= 1;
                while (cur != m) {
                    cur *= 2;
                    y++;
                }
            } else {
                while (cur < m) {
                    cur *= 2;
                    y++;
                }
                y--;
                m -= cur / 2;
                cur = 1;
                while (cur != m) {
                    cur *= 2;
                    x++;
                }

            }
            sb.append(x).append(" ").append(y).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
