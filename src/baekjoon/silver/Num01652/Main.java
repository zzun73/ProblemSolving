package baekjoon.silver.Num01652;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input[j];
            }
        }

        int[] answer = new int[2];
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'X') {
                    if (count >= 2) {
                        answer[0]++;
                    }
                    count = 0;
                } else if (arr[i][j] == '.') {
                    count++;
                }
            }
            if (count >= 2) {
                answer[0]++;
            }
        }
        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i][j] == 'X') {
                    if (count >= 2) {
                        answer[1]++;
                    }
                    count = 0;
                } else if (arr[i][j] == '.') {
                    count++;
                }
            }
            if (count >= 2) {
                answer[1]++;
            }
        }
        sb.append(answer[0]).append(" ").append(answer[1]);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}