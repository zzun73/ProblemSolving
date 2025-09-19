package baekjoon.silver.Num04993;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int W, H, answer;
    static char[][] map;
    static Deque<int[]> deque;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static void helper() {
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || nx > W - 1 || ny < 0 || ny > H - 1 || map[nx][ny] != '.') {
                    continue;
                }
                deque.add(new int[]{nx, ny});
                map[nx][ny] = '#';
                answer++;
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
             H = Integer.parseInt(st.nextToken());
             W = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            map = new char[W][H];
            deque = new ArrayDeque<>();
            answer = 0;

            for (int i = 0; i < W; i++) {
                char[] row = br.readLine().toCharArray();
                for (int j = 0; j < H; j++) {
                    map[i][j] = row[j];
                    if (map[i][j] == '@') {
                        deque.add(new int[]{i, j});
                        map[i][j] = '#';
                        answer++;
                    }
                }
            }

            helper();

            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}