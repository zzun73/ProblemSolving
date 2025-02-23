package baekjoon.bronze.Num04458;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            sb.append((str.charAt(0) + "").toUpperCase()).append(str, 1, str.length()).append('\n');
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}