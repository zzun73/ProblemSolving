package baekjoon.bronze.Num01157;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] word = new int[26];
        String str = br.readLine();


        for (int i = 0; i < str.length(); i++) {
            if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                word[str.charAt(i) - 97]++;
            } else {
                word[str.charAt(i) - 65]++;
            }
        }

        int max = -1;
        char answer = '?';
        for (int i = 0; i < 26; i++) {
            if (word[i] > max) {
                max = word[i];
                answer = (char) (i + 65);
            }
            else if (word[i] == max) {
                answer = '?';
            }
        }

        System.out.print(answer);
        br.close();
    }
}