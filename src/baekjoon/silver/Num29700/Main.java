package baekjoon.silver.Num29700;

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
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                int cur = row.charAt(j) - '0';
                if (cur == 1) {
                    map[i][j] = 0;
                    continue;
                }

                if (j == 0) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i][j - 1] + 1;
                }

                if (map[i][j] >= K) {
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}