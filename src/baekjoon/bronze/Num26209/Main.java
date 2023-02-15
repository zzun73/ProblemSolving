package baekjoon.bronze.Num26209;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        String answer = "S";
        if (N.contains("9")) {
            answer = "F";
        }

        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }
}
