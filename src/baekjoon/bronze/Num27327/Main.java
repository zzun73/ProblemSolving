package baekjoon.bronze.Num27327;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        bw.write(X * 24 + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
