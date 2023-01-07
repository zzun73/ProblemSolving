package baekjoon.bronze.Num05597;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] check = new boolean[31];
        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            check[n] = true;
        }

        int cnt = 0;
        for (int i = 1; i < 31; i++) {
            if (!check[i]) {
                bw.write(i + "\n");
                cnt++;
                if (cnt == 2) {
                    break;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
