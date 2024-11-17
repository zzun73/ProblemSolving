package baekjoon.bronze.Num02935;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger bigInteger = new BigInteger(br.readLine());
        String command = br.readLine();
        BigInteger b = new BigInteger(br.readLine());

        if (command.equals("*")) {
            bw.write(bigInteger.multiply(b).toString());
        } else {
            bw.write(bigInteger.add(b).toString());
        }

        br.close();
        bw.close();
    }
}