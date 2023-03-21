package baekjoon.bronze.Num15000;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer = br.readLine().toUpperCase();
        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }
}
