package baekjoon.bronze.Num02720;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] change = new int[]{25, 10, 5, 1};

        while (T-- > 0) {
            int C = Integer.parseInt(br.readLine());

            for (int val : change) {
                if (C / val > 0) {
                    bw.write(C / val + " ");
                    C %= val;
                } else {
                    bw.write("0 ");
                }
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
