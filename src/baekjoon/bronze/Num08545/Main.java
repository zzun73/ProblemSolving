package baekjoon.bronze.Num08545;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append(br.readLine());
        bw.write(sb.reverse().toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
