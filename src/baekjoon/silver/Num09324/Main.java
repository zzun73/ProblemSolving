package baekjoon.silver.Num09324;

import java.io.*;

public class Main {

    static boolean helper(char[] word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length; i++) {
            int wordIndex = word[i] - 'A';
            count[wordIndex]++;

            if (count[wordIndex] % 3 == 0) {
                if (i == word.length - 1 || (i + 1 < word.length) && word[i + 1] != word[i]) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            sb.append(helper(br.readLine().toCharArray()) ? "FAKE" : "OK").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}