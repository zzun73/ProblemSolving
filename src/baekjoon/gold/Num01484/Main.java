package baekjoon.gold.Num01484;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(br.readLine());
        int left = 1, right = 2;

        while (right <= 100000) {
            int cur = right * right - left * left;
            if (cur == G) {
                sb.append(right).append("\n");
                left++;
                right++;
            } else if (cur > G) {
                left++;
            } else {
                right++;
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}