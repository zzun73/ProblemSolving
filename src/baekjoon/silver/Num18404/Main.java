package baekjoon.silver.Num18404;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X, Y;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int[][] visited;

    static void helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{X, Y});
        visited[X][Y] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < dx.length; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || visited[nx][ny] != -1) {
                    continue;
                }

                deque.add(new int[]{nx, ny});
                visited[nx][ny] = visited[cx][cy] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        visited = new int[N][N];
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            list.add(new int[]{A, B});
        }

        helper();

        for (int[] pos : list) {
            sb.append(visited[pos[0]][pos[1]]).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}