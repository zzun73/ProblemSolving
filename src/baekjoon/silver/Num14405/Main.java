package baekjoon.silver.Num14405;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        input = input.replaceAll("pi|ka|chu", "");

        bw.write(input.isEmpty() ? "YES" : "NO");

        br.close();
        bw.close();
    }
}