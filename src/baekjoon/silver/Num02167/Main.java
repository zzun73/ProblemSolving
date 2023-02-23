package baekjoon.silver.Num02167;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];
        for (int row = 1; row < N + 1; row++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int col = 1; col < M + 1; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int i, j, x, y;
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int answer = 0;
            for (int row = i; row <= x; row++) {
                for (int col = j; col <= y; col++) {
                    answer += arr[row][col];
                }
            }
            bw.write(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
