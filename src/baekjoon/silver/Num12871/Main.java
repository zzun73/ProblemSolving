package baekjoon.silver.Num12871;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        sb1.append(s).append(t);
        sb2 = sb2.append(t).append(s);

        bw.write(sb1.toString().contentEquals(sb2) ? "1" : "0");

        br.close();
        bw.close();
    }
}