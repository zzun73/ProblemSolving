package baekjoon.silver.Num01051;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;

    public static int helper() {
        int size = Math.min(N, M);

        while (size > 1) {
            for (int i = 0; i <= N - size; i++) {
                for (int j = 0; j <= M - size; j++) {
                    int cur = arr[i][j];
                    if (cur == arr[i][j + size - 1] && cur == arr[i + size - 1][j] && cur == arr[i + size - 1][j + size - 1]) {
                        return size;
                    }
                }
            }
            size--;
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input[j] - '0';
            }
        }

        int answer = helper();
        bw.write(String.valueOf(answer * answer));

        br.close();
        bw.flush();
        bw.close();
    }
}