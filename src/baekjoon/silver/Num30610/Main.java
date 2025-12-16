package baekjoon.silver.Num30610;

import java.io.*;
import java.util.*;

public class Main {

    static char[][] map;
    static int N, M;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int helper(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        int count = 1;
        deque.add(new int[]{x, y});
        map[x][y] = '0';

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || map[nx][ny] == '0') {
                    continue;
                }

                map[nx][ny] = '0';
                deque.add(new int[]{nx, ny});
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '1') {
                    list.add(helper(i, j));
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (int val : list) {
            sb.append(val).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}