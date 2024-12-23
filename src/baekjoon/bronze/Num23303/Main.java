package baekjoon.bronze.Num23303;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(br.readLine().toLowerCase().contains("d2") ? "D2" : "unrated");

        br.close();
        bw.close();
    }
}