package baekjoon.bronze.Num31306;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] ch = br.readLine().toCharArray();
        String vowel = "aeiou";
        int vowelCount = 0, yCount = 0;
        for (char c : ch) {
            if (vowel.contains(Character.toString(c))) {
                vowelCount++;
            } else if (c == 'y') {
                yCount++;
            }
        }
        sb.append(vowelCount).append(" ").append(vowelCount + yCount);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}