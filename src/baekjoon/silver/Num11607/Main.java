package baekjoon.silver.Num11607;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        visited[0][0] = true;
        deque.addLast(new int[]{0, 0, 0});

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0];
            int y = cur[1];
            int k = map[cur[0]][cur[1]];

            if (x == N - 1 && y == M - 1) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i] * k;
                int ny = cur[1] + dy[i] * k;

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                deque.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        int answer = helper();
        bw.write(String.valueOf(answer == -1 ? "IMPOSSIBLE" : answer));

        br.close();
        bw.close();
    }
}