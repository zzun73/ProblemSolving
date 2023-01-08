package baekjoon.silver.Num14888;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answerMax, answerMin;
    static int[] number, operator;

    public static void helper(int depth, int value) {
        if (depth == N) {
            answerMax = Math.max(answerMax, value);
            answerMin = Math.min(answerMin, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        helper(depth + 1, value + number[depth]);
                        break;
                    case 1:
                        helper(depth + 1, value - number[depth]);
                        break;
                    case 2:
                        helper(depth + 1, value * number[depth]);
                        break;
                    case 3:
                        helper(depth + 1, value / number[depth]);
                        break;
                }
                operator[i]++;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        operator = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        answerMax = Integer.MIN_VALUE;
        answerMin = Integer.MAX_VALUE;
        helper(1, number[0]);

        bw.write(answerMax + "\n" + answerMin);

        br.close();
        bw.flush();
        bw.close();
    }
}
