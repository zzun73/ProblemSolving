package baekjoon.silver.Num01254;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        if (!str.equals(new StringBuilder(str).reverse().toString())) {
            for (int i = 1; i < str.length(); i++) {
                sb = new StringBuilder(str);
                sb.append(new StringBuilder(str.substring(0, i)).reverse());

                if (sb.toString().equals(sb.reverse().toString())) {
                    break;
                }
            }
        }
        bw.write(String.valueOf(sb.length()));

        br.close();
        bw.flush();
        bw.close();
    }
}