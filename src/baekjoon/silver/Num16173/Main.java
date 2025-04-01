package baekjoon.silver.Num16173;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{1, 0};
    static int[] dy = new int[]{0, 1};

    static boolean helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.push(new int[]{0, 0});
        visited[0][0] = true;

        while (!deque.isEmpty()) {

            int[] cur = deque.poll();
            if (cur[0] == N - 1 && cur[1] == N - 1) {
                return true;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i] * map[cur[0]][cur[1]];
                int ny = cur[1] + dy[i] * map[cur[0]][cur[1]];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                deque.push(new int[]{nx, ny});
            }
        }
        return visited[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
            }
        }

        bw.write(helper() ? "HaruHaru" : "Hing");

        br.close();
        bw.close();
    }
}