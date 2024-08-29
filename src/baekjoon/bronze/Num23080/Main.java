package baekjoon.bronze.Num23080;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (i % k == 0) {
                sb.append(input[i]);
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}