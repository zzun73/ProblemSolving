package baekjoon.silver.Num26099;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        long answer = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                answer += N / 5;
                N = 0;
                break;
            }
            answer++;
            N -= 3;
        }
        bw.write(String.valueOf(N == 0 ? answer : -1));

        br.close();
        bw.flush();
        bw.close();
    }
}
//package baekjoon.silver.Num26099;
//
//import java.io.*;
//import java.math.BigInteger;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        BigInteger N = new BigInteger(br.readLine());
//        BigInteger three = new BigInteger("3");
//        BigInteger five = new BigInteger("5");
//        BigInteger one = new BigInteger("1");
//        BigInteger zero = new BigInteger("0");
//        BigInteger answer = new BigInteger("0");
//
//        while (N.compareTo(zero) > 0) {
//            if ((N.mod(five)).equals(zero)) {
//                answer = answer.add(N.divide(five));
//                N = zero;
//                break;
//            }
//            N = N.subtract(three);
//            answer = answer.add(one);
//        }
//        bw.write(N.equals(zero) ? answer.toString() : "-1");
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}