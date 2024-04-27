package baekjoon.bronze.Num24196;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            i = i + str.charAt(i) - 65;
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}