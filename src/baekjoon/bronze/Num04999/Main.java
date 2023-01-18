package baekjoon.bronze.Num04999;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        if (a.length() >= b.length()) {
            bw.write("go");
        } else {
            bw.write("no");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
