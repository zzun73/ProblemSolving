package baekjoon.bronze.Num05357;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char[] input = br.readLine().toCharArray();
            char prev = input[0];
            sb.append(input[0]);
            for (int i = 1; i < input.length; i++) {
                if (prev != input[i]) {
                    sb.append(input[i]);
                }
                prev = input[i];
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}