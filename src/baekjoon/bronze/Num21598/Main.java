package baekjoon.bronze.Num21598;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String answer = "SciComLove\n";

        bw.write(answer.repeat(N));

        br.close();
        bw.flush();
        bw.close();
    }
}
