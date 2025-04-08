package baekjoon.gold.Num20058;

import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static int[][] map;
    static int[] answer, steps;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static List<Point> decrease;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void helper() {

        for (int L : steps) {
            int step = (int) Math.pow(2, L);
            decrease = new ArrayList<>();
            // 격자 90도 시계방향 회전
            rotate(step);
            // 감소할 얼음 조사
            searchMap();
            // 동시에 얼음 감소
            decreaseIce();
        }

        getAnswer();
    }

    // step단위로 부분 격자 시계방향 90도 회전
    static void rotate(int step) {
        int[][] temp = new int[N][N];
        for (int x = 0; x < N; x += step) {
            for (int y = 0; y < N; y += step) {
                for (int i = 0; i < step; i++) {
                    for (int j = 0; j < step; j++) {
                        temp[x + j][y + step - 1 - i] = map[x + i][y + j];
                    }
                }
            }
        }
        map = temp;
    }

    static void getAnswer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    int[] res = findMaxIceArea(i, j);
                    answer[0] += res[0];
                    answer[1] = Math.max(answer[1], res[1]);
                }
            }

        }
    }

    static int[] findMaxIceArea(int x, int y) {
        int[] result = new int[2];
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(x, y));
        result[0] += map[x][y];
        result[1]++;
        map[x][y] = 0;

        while (!deque.isEmpty()) {
            Point cur = deque.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isOut(nx, ny) || map[nx][ny] == 0) {
                    continue;
                }
                result[0] += map[nx][ny];
                map[nx][ny] = 0;
                result[1]++;

                deque.add(new Point(nx, ny));
            }
        }

        return result;
    }

    static void decreaseIce() {
        for (Point cur : decrease) {
            if (map[cur.x][cur.y] > 0) {
                map[cur.x][cur.y]--;
            }
        }
    }

    // 각 격자칸마다 얼음아닌것(0) 2개 이상 인접할 경우 얼음양 1칸 줄이기(동시에 반영하기 위해 따로 저장)
    static void searchMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (findIce(i, j)) {
                    decrease.add(new Point(i, j));
                }
            }
        }
    }

    static boolean findIce(int x, int y) {
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isOut(nx, ny) || map[nx][ny] == 0) {
                count++;
            }
        }
        return count >= 2;
    }

    static boolean isOut(int x, int y) {
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        Q = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        answer = new int[2];
        steps = new int[Q];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < Q; i++) {
            steps[i] = Integer.parseInt(st.nextToken());
        }

        helper();

        sb.append(answer[0]).append("\n").append(answer[1]);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
