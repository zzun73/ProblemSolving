package baekjoon.bronze.Num04806;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        while (br.readLine() != null) {
            answer++;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}