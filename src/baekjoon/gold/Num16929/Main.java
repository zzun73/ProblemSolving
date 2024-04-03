package baekjoon.gold.Num16929;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, startX, startY;
    static boolean isCycle;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static boolean helper() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                startX = i;
                startY = j;
                cycleCheck(1, i, j);

                if (isCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    static void cycleCheck(int depth, int x, int y) {
        if (isCycle) {
            return;
        }
        if (x == startX && y == startY && depth != 1) {
            if (depth >= 4) {
                isCycle = true;
            }
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny] || map[nx][ny] != map[startX][startY]) {
                continue;
            }
            visited[nx][ny] = true;
            cycleCheck(depth + 1, nx, ny);
            visited[nx][ny] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isCycle = false;

        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bw.write(helper() ? "Yes" : "No");
        br.close();
        bw.close();
    }

}