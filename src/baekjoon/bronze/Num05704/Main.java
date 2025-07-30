package baekjoon.bronze.Num05704;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        while (true) {
            String str = br.readLine();

            if (str.equals("*")) {
                break;
            }

            int[] alpha = new int[26];
            for (char ch : str.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    alpha[ch - 'a']++;
                }
            }

            boolean isFanGram = true;
            for (int val : alpha) {
                if (val == 0) {
                    isFanGram = false;
                    break;
                }
            }
            sb.append(isFanGram ? "Y" : "N").append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}