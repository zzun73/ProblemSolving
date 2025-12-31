package baekjoon.bronze.Num06750;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().replaceAll("[IOSHZXN]", "");
        bw.write(str.isEmpty() ? "YES" : "NO");

        br.close();
        bw.close();
    }
}