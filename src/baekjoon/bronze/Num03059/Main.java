package baekjoon.bronze.Num03059;

import java.io.*;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int initSum = 0;

        for (int i = 0; i < 26; i++) {
            initSum += 'A' + i;
        }

        for (int i = 0; i < T; i++) {
            int curSum = 0;

            String S = br.readLine();
            char[] ch = S.toCharArray();
            HashSet<Integer> set = new HashSet<>();

            for (int j = 0; j < S.length(); j++) {
                set.add((int) ch[j]);
            }

            for (int val : set) {
                curSum += val;
            }

            sb.append(initSum - curSum).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}