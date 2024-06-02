package baekjoon.bronze.Num30958;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] alpha = new int[26];
        int[] count = new int[26];
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = 97 + i;
            count[i] = 0;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (str.charAt(i) == alpha[j]) {
                    count[j]++;
                }
            }
        }

        int answer = count[0];
        for (int i = 0; i < count.length; i++) {
            answer = Math.max(answer, count[i]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}