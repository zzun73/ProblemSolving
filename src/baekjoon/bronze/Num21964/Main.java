package baekjoon.bronze.Num21964;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        bw.write(str.substring(N - 5));

        br.close();
        bw.flush();
        bw.close();
    }
}