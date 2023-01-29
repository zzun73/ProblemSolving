package baekjoon.bronze.Num24568;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int R = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());

        bw.write((R * 8 + S * 3) - 28 + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
