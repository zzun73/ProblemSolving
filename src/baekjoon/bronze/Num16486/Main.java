package baekjoon.bronze.Num16486;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());
        double round = 3.141592 * 2 * d2;

        bw.write(d1 * 2 + round + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
