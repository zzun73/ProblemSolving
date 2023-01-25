package baekjoon.bronze.Num08437;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger apple = new BigInteger(br.readLine());
        BigInteger diff = new BigInteger(br.readLine());
        BigInteger human = new BigInteger("2");

        bw.write(apple.add(diff).divide(human) + "\n" + apple.subtract(diff).divide(human) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
