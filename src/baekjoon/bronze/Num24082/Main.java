package baekjoon.bronze.Num24082;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        bw.write(x * x * x + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
