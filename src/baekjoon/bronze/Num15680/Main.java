package baekjoon.bronze.Num15680;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String answer = N == 0 ? "YONSEI" : "Leading the Way to the Future";
        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }
}
