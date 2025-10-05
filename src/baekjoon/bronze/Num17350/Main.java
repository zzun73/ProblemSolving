package baekjoon.bronze.Num17350;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean answer = false;
        for (int i = 0; i < N; i++) {
            if ("anj".equals(br.readLine())) {
                answer = true;
                break;
            }
        }

        bw.write(answer ? "뭐야;" : "뭐야?");

        br.close();
        bw.close();
    }
}