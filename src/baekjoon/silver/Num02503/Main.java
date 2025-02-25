package baekjoon.silver.Num02503;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] hint = new int[N][3];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            hint[i][0] = number;
            hint[i][1] = strike;
            hint[i][2] = ball;
        }


        for (int i = 100; i <= 987; i++) {
            int[] curNumber = {i / 100, (i / 10) % 10, i % 10};
            if (curNumber[1] == 0 || curNumber[2] == 0 || curNumber[0] == curNumber[1] || curNumber[0] == curNumber[2] || curNumber[1] == curNumber[2]) {
                continue;
            }

            int count = 0;
            for (int[] h : hint) {
                int target = h[0];
                int strikeCount = 0, ballCount = 0;

                int[] targetNumber = {target / 100, (target / 10) % 10, target % 10};


                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (curNumber[x] == targetNumber[y]) {
                            if (x == y) {
                                strikeCount++;
                            } else {
                                ballCount++;
                            }
                        }
                    }
                }

                if (strikeCount == h[1] && ballCount == h[2]) {
                    count++;
                }
            }

            if (count == N) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}