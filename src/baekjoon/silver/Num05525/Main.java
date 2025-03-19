package baekjoon.silver.Num05525;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int answer = 0, start = 0;

        while (start < N * M - 2) {
            if (S[start] == 'O') {
                start++;
                continue;
            }

            int count = 0;
            while (start + 2 < M && S[start + 1] == 'O' && S[start + 2] == 'I') {
                count++;
                start += 2;
                if (count >= N) {
                    answer++;
                }
            }
            start++;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
