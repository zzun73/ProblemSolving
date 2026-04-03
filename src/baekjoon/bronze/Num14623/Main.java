package baekjoon.bronze.Num14623;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String B1 = br.readLine();
        String B2 = br.readLine();

        long num1 = Long.parseLong(B1, 2);
        long num2 = Long.parseLong(B2, 2);

        long result = num1 * num2;

        bw.write(Long.toBinaryString(result));

        br.close();
        bw.close();
    }
}