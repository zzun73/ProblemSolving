package baekjoon.bronze.Num10214;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        String winY = "Yonsei\n";
        String winK = "Korea\n";
        String tie = "Draw\n";

        while (T-- > 0) {

            int Y = 0;
            int K = 0;

            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                Y += Integer.parseInt(st.nextToken());
                K += Integer.parseInt(st.nextToken());
            }

            if (Y > K) {
                bw.write(winY);
            } else {
                if ((Y == K)) {
                    bw.write(tie);
                } else {
                    bw.write(winK);
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
