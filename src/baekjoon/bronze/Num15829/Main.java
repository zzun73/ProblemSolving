package baekjoon.bronze.Num15829;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int r = 31;
        int M = 1234567891;
        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = i + 1;
        }

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        long pow = 1;
        for (int i = 0; i < L; i++) {
            answer = (answer + alphabet[str.charAt(i) - 'a'] * pow % M) % M;
            pow = (pow * r) % M;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
