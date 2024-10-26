package baekjoon.silver.Num02607;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] source = new int[26];
        int answer = 0;

        N--;
        char[] sourceStr = br.readLine().toCharArray();
        for (char ch : sourceStr) {
            source[ch - 'A']++;
        }

        while (N-- > 0) {
            int[] target = new int[26];
            char[] targetStr = br.readLine().toCharArray();

            if (Math.abs(targetStr.length - sourceStr.length) > 1) {
                continue;
            }

            for (char ch : targetStr) {
                target[ch - 'A']++;
            }

            int addOrRemove = 0;
            int replace = 0;

            for (int i = 0; i < 26; i++) {
                int diff = target[i] - source[i];
                if (diff > 0) {
                    addOrRemove += diff;
                } else if (diff < 0) {
                    replace -= diff;
                }
            }

            if (addOrRemove + replace <= 2) {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}