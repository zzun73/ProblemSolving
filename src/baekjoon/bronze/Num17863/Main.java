package baekjoon.bronze.Num17863;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        String answer = N.startsWith("555") ? "YES" : "NO";

        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }
}
