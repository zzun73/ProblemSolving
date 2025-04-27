package baekjoon.silver.Num14620;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static void helper(int depth, int curCost) {
        if (curCost > answer) {
            return;
        }

        if (depth == 3) {
            answer = Math.min(answer, curCost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (isPossible(i, j)) {
                    helper(depth + 1, curCost + markMap(i, j));
                    cleanMap(i, j);
                }
            }
        }
    }

    static boolean isPossible(int cx, int cy) {
        if (visited[cx][cy]) {
            return false;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }


    static int markMap(int cx, int cy) {
        int result = map[cx][cy];
        visited[cx][cy] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            visited[nx][ny] = true;
            result += map[nx][ny];
        }
        return result;
    }

    static void cleanMap(int cx, int cy) {
        visited[cx][cy] = false;
        for (int i = 0; i < dx.length; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        helper(0, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}