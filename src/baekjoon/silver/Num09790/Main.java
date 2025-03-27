package baekjoon.silver.Num09790;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int W, H, count;
    static char[][] map;
    static Deque<int[]> deque;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static void helper() {
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '#') {
                    continue;
                }
                map[nx][ny] = '#';
                deque.add(new int[]{nx, ny});
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            count = 0;
            map = new char[H][W];
            deque = new ArrayDeque<>();

            for (int i = 0; i < H; i++) {
                char[] row = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    map[i][j] = row[j];
                    if (map[i][j] == 'A') {
                        deque.add(new int[]{i, j});
                        map[i][j] = '#';
                        count++;
                    }
                }
            }

            helper();
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}