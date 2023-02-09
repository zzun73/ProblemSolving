package baekjoon.silver.Num01439;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stZero, stONE;

        String S = br.readLine();
        stZero = new StringTokenizer(S, "0");
        stONE = new StringTokenizer(S, "1");

        int answer = Math.min(stZero.countTokens(), stONE.countTokens());

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
