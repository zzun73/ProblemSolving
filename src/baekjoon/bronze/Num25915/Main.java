package baekjoon.bronze.Num25915;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = br.readLine().charAt(0);
        bw.write(String.valueOf(Math.abs(c - 'I') + 84));

        br.close();
        bw.close();
    }
}