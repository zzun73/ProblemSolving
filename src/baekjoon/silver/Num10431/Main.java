package baekjoon.silver.Num10431;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            int answer = 0;
            int[] arr = new int[SIZE];

            st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            for (int i = 0; i < SIZE; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < SIZE; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] < arr[j]) {
                        answer++;
                    }
                }
            }

            sb.append(T).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}