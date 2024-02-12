package baekjoon.silver.Num14888;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, maxAnswer, minAnswer;
    static int[] operand, operator;

    static void helper(int depth, int pathNum) {
        if (depth == N - 1) { // 연산자 모두 사용
            maxAnswer = Math.max(maxAnswer, pathNum);
            minAnswer = Math.min(minAnswer, pathNum);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        helper(depth + 1, pathNum + operand[depth + 1]);
                        break;
                    case 1:
                        helper(depth + 1, pathNum - operand[depth + 1]);
                        break;
                    case 2:
                        helper(depth + 1, pathNum * operand[depth + 1]);
                        break;
                    case 3:
                        helper(depth + 1, pathNum / operand[depth + 1]);
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
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        operand = new int[N];
        operator = new int[4];
        maxAnswer = Integer.MIN_VALUE;
        minAnswer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            operand[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < operator.length; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        helper(0, operand[0]);

        sb.append(maxAnswer).append("\n").append(minAnswer);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}