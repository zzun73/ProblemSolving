package baekjoon.bronze.Num35261;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] target = new char[]{'e', 'a', 'g', 'l', 'e'};
        char[] input = br.readLine().toCharArray();

        int answer = 5;
        for (int i = 0; i <= N - 5; i++) {
            int count = 0;
            for (int j = i; j < i + 5; j++) {
                if (input[j] != target[j - i]) {
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