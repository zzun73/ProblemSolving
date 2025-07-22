package baekjoon.silver.Num21221;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};

    static char[][] map;
    static char[][] answer;

    static void helper(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isOut(nx, ny)) {
                continue;
            }
            answer[nx][ny] = '#';
        }
    }

    static boolean isOut(int x, int y) {
        return x < 0 || x > N - 1 || y < 0 || y > M - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        answer = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            answer[i] = map[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#') {
                    helper(i, j);
                }
            }
        }

        for (char[] row : answer) {
            for (char ch : row) {
                sb.append(ch);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}