package baekjoon.silver.Num01522;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int size = 0;
        for (char ch : input) {
            if (ch == 'a') {
                size++;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            int count = 0;
            for (int j = i; j < i + size; j++) {
                if (input[j % input.length] == 'b') {
                    count++;
                }
            }
            answer = Math.min(answer, count);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}