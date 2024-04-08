package baekjoon.gold.Num17141;

import java.io.*;
import java.util.*;

class Virus {
    int x, y, time;

    public Virus(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    static int N, M, answer, totalVirusSum;
    static int[][] map, originMap;
    static boolean[] selected;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Deque<Virus> deque;
    static List<Virus> virus;

    static boolean isAllSpread() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) { // 한 칸이라도 빈칸이 존재 할 경우
                    return false;
                }
            }
        }
        return true;
    }

    // 바이러스 M개 만큼 놓기
    static void combi(int depth, int idx) {
        if (depth == M) {

            copyMap();
            deque = new ArrayDeque<>();

            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    int x = virus.get(i).x;
                    int y = virus.get(i).y;
                    map[x][y] = 1; // 지나간곳 표시
                    deque.add(new Virus(x, y, 1));
                }
            }

            int time = spread();

            if (isAllSpread()) {
                answer = Math.min(answer, time);
            }

            return;
        }


        for (int i = idx; i < selected.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                combi(depth + 1, i + 1);
                selected[i] = false;
            }
        }
    }

    static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = originMap[i][j];
            }
        }
    }

    static int spread() {
        int resultTime = 0;
        while (!deque.isEmpty()) {
            Virus cur = deque.poll();
            int x = cur.x;
            int y = cur.y;
            int t = cur.time;
            resultTime = Math.max(resultTime, t);
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || map[nx][ny] != 0) {
                    continue;
                }
                map[nx][ny] = 9; // 지나간 곳 표시
                deque.add(new Virus(nx, ny, t + 1));
            }
        }
        return resultTime - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originMap = new int[N][N];
        map = new int[N][N];
        virus = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        totalVirusSum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
                if (originMap[i][j] == 2) { // 바이러스가 있을 수 있는 위치인 경우
                    originMap[i][j] = 0;
                    virus.add(new Virus(i, j, 0));
                    totalVirusSum++;
                } else if (originMap[i][j] == 0) {
                    totalVirusSum++;
                }
            }
        }

        selected = new boolean[virus.size()];
        if (totalVirusSum == 0) {
            answer = 0;
        } else {
            combi(0, 0);
        }
        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));

        br.close();
        bw.close();
    }
}