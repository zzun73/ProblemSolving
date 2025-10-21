package baekjoon.silver.Num11260;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static  int[] dx = { -1, -1, 0, 1, 1,  1,  0, -1 };
    static  int[] dy = {  0,  1, 1, 1, 0, -1, -1, -1 };


    static boolean check(int x, int y) {
        int count = 0;
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isOut(nx, ny)) {
                count++;
                continue;
            }

            if (map[nx][ny] != '#') {
                count++;
            }
        }
        return count == 8;
    }

    static boolean isOut(int x, int y) {
        return x < 0 || x > N - 1 || y < 0 || y > M - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '#') {
                        if (check(i, j)) {
                            answer++;
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}