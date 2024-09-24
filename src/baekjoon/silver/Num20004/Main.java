package baekjoon.silver.Num20004;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (30 % (i + 1) == 0)
                sb.append(i).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}