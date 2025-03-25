package baekjoon.silver.Num33656;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int R, C, answer;
    static char[][] map;
    static Deque<int[]> deque;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};


    static void helper() {
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > R - 1 || ny >= C - 1 || map[nx][ny] != '#') {
                    continue;
                }
                map[nx][ny] = '.';
                deque.offer(new int[]{nx, ny});
                answer++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        map = new char[R][C];
        deque = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'S') {
                    deque.add(new int[]{i, j});
                    answer++;
                    map[i][j] = '.';
                }
            }
        }
        helper();
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}