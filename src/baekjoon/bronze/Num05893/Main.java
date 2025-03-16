package baekjoon.bronze.Num05893;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new BigInteger(br.readLine(), 2).multiply(BigInteger.valueOf(17)).toString(2));

        br.close();
        bw.close();
    }
}