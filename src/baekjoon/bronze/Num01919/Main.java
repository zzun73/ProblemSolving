package baekjoon.bronze.Num01919;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        char[] firstInput = br.readLine().toCharArray();
        char[] secondInput = br.readLine().toCharArray();

        char[] firstFreq = new char[26];
        char[] secondFreq = new char[26];

        for (char c : firstInput) {
            firstFreq[c - 'a']++;
        }
        for (char c : secondInput) {
            secondFreq[c - 'a']++;
        }
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += (Math.abs(firstFreq[i] - secondFreq[i]));
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
