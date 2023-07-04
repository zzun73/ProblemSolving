package baekjoon.silver.Num01012;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int M, N, K;
    static int count;

    public static void helper(int x, int y) {
        if (x < 0 || x > M - 1 || y < 0 || y > N - 1 || arr[x][y] == 0) {
            return;
        }
        arr[x][y] = 0;
        count++;
        helper(x + 1, y);
        helper(x - 1, y);
        helper(x, y + 1);
        helper(x, y - 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            int answer = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    count = 0;
                    helper(i, j);
                    if (count != 0) {
                        answer++;
                    }
                }
            }
            bw.write(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

