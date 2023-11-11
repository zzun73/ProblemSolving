package swea.d3.Num01289;

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] original = br.readLine().toCharArray();
            char[] init = new char[original.length];
            int answer = 0;

            Arrays.fill(init, '0');
            for (int i = 0; i < init.length; i++) {
                if (init[i] != original[i]) {
                    answer++;
                    int temp = i;
                    char val = original[i];
                    while (temp < init.length) {
                        init[temp++] = val;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}