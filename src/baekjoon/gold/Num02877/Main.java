package baekjoon.gold.Num02877;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine()) + 1;

        String num = Integer.toBinaryString(K);
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                sb.append('4');
            } else {
                sb.append('7');
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}