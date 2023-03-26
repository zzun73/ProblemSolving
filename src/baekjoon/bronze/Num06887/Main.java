package baekjoon.bronze.Num06887;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write("The largest square has side length " + (int) Math.sqrt(N) + ".");

        br.close();
        bw.flush();
        bw.close();
    }
}
