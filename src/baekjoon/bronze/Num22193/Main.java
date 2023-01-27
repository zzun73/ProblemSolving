package baekjoon.bronze.Num22193;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String garbage = br.readLine();

        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());
        bw.write(A.multiply(B) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
