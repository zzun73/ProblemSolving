package baekjoon.gold.Num03109;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, answer;
    static char[][] board;
    static boolean[][] visited;
    static boolean arrive;
    static int[] dx = new int[]{-1, 0, 1};

    static void helper(int x, int y) {
        if (arrive) { // 이미 도착했을 경우 다른 경로 볼 필요 X
            return;
        }

        visited[x][y] = true; // 방문 표시

        if (y == C - 1) { // 끝에 도달했을 경우
            arrive = true;
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + 1;

            // 배열 범위 밖 or 이미 방문 or 건물
            if (nx < 0 || nx > R - 1 || ny > C - 1 || visited[nx][ny] || board[nx][ny] == 'x') {
                continue;
            }
            helper(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 첫번째 열 차례로 진행
        for (int i = 0; i < R; i++) {
            arrive = false;
            helper(i, 0);

            if (arrive) {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
