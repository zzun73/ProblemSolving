package baekjoon.bronze.Num05613;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = Integer.parseInt(br.readLine());
        String input;

        while (!(input = br.readLine()).equals("=")) {
            int N = Integer.parseInt(br.readLine());

            if (input.equals("+")) {
                answer += N;
            } else if (input.equals("-")) {
                answer -= N;
            } else if (input.equals("*")) {
                answer *= N;
            } else if (input.equals("/")) {
                answer /= N;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}