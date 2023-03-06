package baekjoon.bronze.Num24883;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        if (input.equals("n") || input.equals("N")) {
            bw.write("Naver D2");
        } else {
            bw.write("Naver Whale");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
