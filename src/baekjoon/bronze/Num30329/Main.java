package baekjoon.bronze.Num30329;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int answer = 0;
        for (int i = 0; i <= input.length - 4; i++) {
            if (input[i] == 'k' && input[i + 1] == 'i' && input[i + 2] == 'c' && input[i + 3] == 'k') {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}