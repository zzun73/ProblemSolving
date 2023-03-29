package baekjoon.bronze.Num08558;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = 1;
        int i = 1;
        while (i <= N) {
            answer *= i;
            answer %= 10;
            i++;
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
