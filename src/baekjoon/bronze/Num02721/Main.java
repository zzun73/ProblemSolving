package baekjoon.bronze.Num02721;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int sum = 0;
            int n = Integer.parseInt(br.readLine());
            for (int j = 1; j <= n; j++) {
                int A = 0;

                for (int k = 1; k <= (j + 1); k++) {
                    A += k;
                }
                sum += (j * A);
            }
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}