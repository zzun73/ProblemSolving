package baekjoon.gold.Num16935;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, temp;
    static int[][] arr, res;
    static StringBuilder sb = new StringBuilder();

    // 상하 반전 시키기
    static void first() {
        // 열 기준으로 위아래 swap 진행
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N / 2; i++) {
                int temp = arr[i][j];
                arr[i][j] = arr[N - i - 1][j];
                arr[N - i - 1][j] = temp;
            }
        }
    }

    // 좌우 반전 시키기
    static void second() {
        // 행 기준으로 좌우 swap 진행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = arr[i][M - j - 1];
                arr[i][M - j - 1] = arr[i][j];
                arr[i][j] = temp;
            }
        }
    }

    // 오른쪽 90도 회전 시키기
    static void third() {
        res = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int temp = arr[i][j];
                res[j][i] = arr[N - i - 1][j];
                arr[i][j] = temp;
            }
        }
        arr = res;

        temp = N;
        N = M;
        M = temp;
    }

    // 왼쪽 90도 회전 시키기
    static void fourth() {
        res = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int temp = arr[i][j];
                res[j][i] = arr[i][M - j - 1];
                arr[i][j] = temp;
            }
        }
        temp = N;
        N = M;
        M = temp;
        arr = res;
    }

    //4그룹 분할한 다음 시계방향으로 회전시키기
    static void fifth() {
        res = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                res[i][j] = arr[i + N / 2][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                res[i][j] = arr[i][j - M / 2];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                res[i][j] = arr[i - N / 2][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                res[i][j] = arr[i][j + M / 2];
            }
        }
        arr = res;
    }

    //4그룹 분할한 다음 반시계방향으로 회전시키기
    static void sixth() {
        res = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                res[i][j] = arr[i][j + M / 2];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                res[i][j] = arr[i + N / 2][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                res[i][j] = arr[i][j - M / 2];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                res[i][j] = arr[i - N / 2][j];
            }
        }
        arr = res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (String cmd : br.readLine().split(" ")) {
            switch (cmd) {
                case "1":
                    first();
                    break;
                case "2":
                    second();
                    break;
                case "3":
                    third();
                    break;
                case "4":
                    fourth();
                    break;
                case "5":
                    fifth();
                    break;
                case "6":
                    sixth();
                    break;
            }
        }

        for (int[] row : arr) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}