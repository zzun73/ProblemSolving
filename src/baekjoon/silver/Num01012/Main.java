package baekjoon.silver.Num01012;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int M, N;
    static int[][] arr;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void helper(int x, int y) {
        ArrayDeque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(x, y));
        arr[x][y] = 0;

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1 || arr[nx][ny] == 0) {
                    continue;
                }
                deque.add(new Pos(nx, ny));
                arr[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[M][N];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[X][Y] = 1;
            }

            int answer = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) {
                        helper(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}