package baekjoon.silver.Num15312;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        char[] chars = new char[A.length + B.length];
        int[] answer = new int[chars.length];
        int idx = 0, idxA = 0, idxB = 0;
        while (idxA < A.length && idxB < B.length) {
            answer[idx++] = alphabet[A[idxA++] - 'A'];
            answer[idx++] = alphabet[B[idxB++] - 'A'];
        }

        int val = 1;
        while (answer.length - val >= 2) {
            for (int i = 0; i < answer.length - val; i++) {
                answer[i] = (answer[i] + answer[i + 1]) % 10;
            }
            val++;
        }
        sb.append(answer[0]).append(answer[1]);
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}