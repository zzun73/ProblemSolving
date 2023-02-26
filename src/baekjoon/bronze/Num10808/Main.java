package baekjoon.bronze.Num10808;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int[] alpabet = new int[26];
        for (char ch : input) {
            alpabet[ch - 'a']++;
        }

        for (int val : alpabet) {
            bw.write(val + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
