package baekjoon.silver.Num11370;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int W, H, sx, sy;
    static char[][] map;
    static Deque<int[]> deque;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static void helper() {
        deque.add(new int[]{sx, sy});
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx > H - 1 || ny < 0 || ny > W - 1 || visited[nx][ny] || map[nx][ny] != 'T') {
                    continue;
                }
                map[nx][ny] = 'S';
                deque.add(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        deque = new ArrayDeque<>();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0) {
                break;
            }
            map = new char[H][W];
            visited = new boolean[H][W];
            sx = sy = 0;
            for (int i = 0; i < H; i++) {
                String row = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = row.charAt(j);
                    if (map[i][j] == 'S') {
                        sx = i;
                        sy = j;
                    }
                }
            }
            helper();

            for (char[] row : map) {
                for (char c : row) {
                    sb.append(c);
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}