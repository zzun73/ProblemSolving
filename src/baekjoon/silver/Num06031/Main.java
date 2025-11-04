package baekjoon.silver.Num06031;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static char[][] map;
    static boolean[][] visited;
    static  int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
    static  int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};

    static int helper(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        int result = 1;
        visited[x][y] = true;
        deque.add(new int[]{x, y});

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int d = 0; d < 8; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx > H - 1 || ny < 0 || ny > W - 1 || visited[nx][ny] || map[nx][ny] == '*') {
                    continue;
                }
                result++;
                visited[nx][ny] = true;
                deque.add(new int[]{nx, ny});
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '.') {
                    answer = Math.max(helper(i, j), answer);
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}