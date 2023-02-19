package baekjoon.bronze.Num27328;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        String answer = A > B ? "1" : (A == B ? "0" : "-1");

        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }
}
