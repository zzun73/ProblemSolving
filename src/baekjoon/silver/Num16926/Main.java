package baekjoon.silver.Num16926;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R, temp, size;
    static int[][] arr;

    static void helper() {

        for (int pos = 0; pos < size; pos++) {
            temp = arr[pos][pos];

            // 좌 (윗 줄)
            for (int j = pos; j < M - pos - 1; j++) {
                arr[pos][j] = arr[pos][j + 1];
            }

            // 상 (오른쪽 줄)
            for (int i = pos; i < N - pos - 1; i++) {
                arr[i][M - pos - 1] = arr[i + 1][M - pos - 1];
            }

            // 우 (아래쪽 줄)
            for (int j = M - pos - 1; j > pos; j--) {
                arr[N - pos - 1][j] = arr[N - pos - 1][j - 1];
            }

            // 하 (왼쪽 줄)
            for (int i = N - pos - 1; i > pos; i--) {
                arr[i][pos] = arr[i - 1][pos];
            }

            arr[pos + 1][pos] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        size = Math.min(N, M) / 2; // 배열내에 사각형 반시계방향 도는 횟수

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (R-- > 0) {
            helper();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}