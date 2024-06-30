package baekjoon.silver.Num14468;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] cow = new int[26][2];
        char[] alpha = br.readLine().toCharArray();
        for (int i = 0; i < alpha.length; i++) {
            int idx = alpha[i] - 'A';
            if (cow[idx][0] == 0) {
                cow[idx][0] = i + 1;

            } else {
                cow[idx][1] = i + 1;
            }

        }

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (cow[i][0] < cow[j][0] && cow[j][0] < cow[i][1] && cow[i][1] < cow[j][1]) {
                    ++answer;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}