package baekjoon.bronze.Num05358;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;

        while ((str = br.readLine()) != null) {
            char[] input = str.toCharArray();
            for (int i = 0; i < input.length; i++) {
                if (input[i] == 'i') {
                    input[i] = 'e';
                } else if (input[i] == 'e') {
                    input[i] = 'i';
                } else if (input[i] == 'I') {
                    input[i] = 'E';
                } else if (input[i] == 'E') {
                    input[i] = 'I';
                }
                sb.append(input[i]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}