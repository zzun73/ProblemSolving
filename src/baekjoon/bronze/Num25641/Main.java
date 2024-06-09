package baekjoon.bronze.Num25641;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sCount = 0, tCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 's') {
                sCount++;
            } else {
                tCount++;
            }
        }

        int leftIndex = 0;
        while (sCount != tCount) {
            if (s.charAt(leftIndex) == 's') {
                sCount--;
            } else {
                tCount--;
            }
            leftIndex++;
        }
        bw.write(s.substring(leftIndex));

        br.close();
        bw.close();
    }
}