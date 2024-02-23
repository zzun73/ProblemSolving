package baekjoon.gold.Num02458;

import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = 100000000;
    static int N, M, a, b, count, answer;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int[] row : arr) {
            Arrays.fill(row, INF);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != INF || arr[j][i] != INF) {
                    count++;
                }
            }

            if (count == N - 1) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}