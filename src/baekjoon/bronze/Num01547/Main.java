package baekjoon.bronze.Num01547;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] balls = new boolean[]{false, true, false, false};
        boolean temp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            temp = balls[A];
            balls[A] = balls[B];
            balls[B] = temp;
        }
        for (int i = 1; i <= 3; i++) {
            if (balls[i]) {
                bw.write(String.valueOf(i));
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}