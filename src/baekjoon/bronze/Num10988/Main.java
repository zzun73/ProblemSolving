package baekjoon.bronze.Num10988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String revereStr = sb.append(str).reverse().toString();

        bw.write(str.equals(revereStr) ? "1" : "0");
        br.close();
        bw.flush();
        bw.close();
    }
}