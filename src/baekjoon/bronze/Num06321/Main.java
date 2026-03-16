package baekjoon.bronze.Num06321;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] input = br.readLine().toCharArray();
            for (int i = 0; i < input.length; i++) {
                if (input[i] == 'Z') {
                    input[i] = 'A';
                } else {
                    input[i] = (char) (input[i] + 1);
                }
            }


            sb.append("String #").append(t).append("\n");
            for (char ch : input) {
                sb.append(ch);
            }
            sb.append("\n\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}