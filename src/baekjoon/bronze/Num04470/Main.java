package baekjoon.bronze.Num04470;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int seq = 1;
        StringBuilder sb = new StringBuilder();
        while (seq <= N) {
            sb.append(seq).append(". ").append(br.readLine()).append("\n");
            seq++;
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
