package baekjoon.gold.Num21278;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INF;
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A][B] = 1;
            map[B][A] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        int[] answer = new int[]{0,0,Integer.MAX_VALUE};
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int[] distance = new int[N + 1];
                int sum = 0;
                for (int k = 1; k <= N; k++) {
                    distance[k] = Math.min(map[i][k], map[j][k]);
                }
                for (int k = 1; k <= N; k++) {
                    sum += distance[k];
                }
                sum*=2; // 왕복
                if (answer[2] > sum) {
                    answer[2]  = sum;
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for (int val : answer) {
            sb.append(val).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}