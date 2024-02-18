package baekjoon.gold.Num17135;

import java.io.*;
import java.util.*;

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {

    static int N, M, D; // D: 궁수 공격 사거리
    static int[][] map, gameMap; // 0: 빈칸, 1: 적이 있는 칸
    static int answer; // 최대로 잡은 적군 수
    static int initEnemy; // 초기 enemy 수
    static HashSet<Pos> enemyPosition = new HashSet<>(); // 적군 잡을 좌표
    static List<List<Integer>> archerList; // 궁수 배정 가능한 위치 리스트
    static Deque<int[]> deque = new ArrayDeque<>();
    static boolean[] selected; // 궁수 선택
    static boolean[][] visited; // 사거리 탐색시 중복 탐색 방지

    // 사거리 안에 적 여러명일 경우 왼쪽 먼저 (y좌표 작은 순)
    static int[] dx = new int[]{0, -1, 0};
    static int[] dy = new int[]{-1, 0, 1};

    static void startGame() {
        selelctArcher(0, 0); // 궁수 위치 리스트 구하기

        for (List<Integer> archer : archerList) {

            copyMap();

            int totalCount = 0;
            for (int row = N - 1; row >= 0; row--) { // 가장 밑에 행부터 궁수들 한칸씩 앞으로 전진
                totalCount += attack(archer, row); // 라운드별 잡은 적군 수 누적
            }
            answer = Math.max(totalCount, answer); // 잡을 수 있는 적군 최대값 갱신

            if (answer == initEnemy) { // 필드에 있는 적군 모두 다 잡을 수 있는 경우
                return;
            }
        }
    }

    // 게임 진행할 맵 복사
    static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                gameMap[i][j] = map[i][j];
            }
        }
    }

    // 궁수 공격
    static int attack(List<Integer> archer, int row) {
        enemyPosition.clear();
        for (Integer col : archer) {
            deque.clear();
            visited = new boolean[N][M];

            deque.add(new int[]{row, col, 1}); // 궁수 위치 삽입 (행, 열, 거리)
            visited[row][col] = true;

            int ex, ey, minDistance;
            ex = ey = minDistance = Integer.MAX_VALUE;

            // 궁수 하나당 자신의 사거리 내 적군 찾기
            while (!deque.isEmpty()) {
                int[] cur = deque.poll();

                if (gameMap[cur[0]][cur[1]] == 1 && cur[2] <= D) { // 적군이면서

                    if (cur[2] <= minDistance) { // 거리가 작거나 같을 경우
                        if (cur[2] < minDistance || cur[1] < ey) { // 거리가 더 작거나, r같은 거리일 경우 가장 왼쪽
                            ex = cur[0];
                            ey = cur[1];
                            minDistance = cur[2];
                        }
                    }
                }

                for (int i = 0; i < dx.length; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    int nd = getDistance(row, col, nx, ny) + 1;

                    // 배열 범위 밖 or 이미 방문 or 사거리 초과일 경우
                    if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny] || nd > D) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny, nd});
                }
            }

            // 기준에 맞는 화살 쏠 적군 좌표 추가
            if (minDistance != Integer.MAX_VALUE && gameMap[ex][ey] == 1) {
                enemyPosition.add(new Pos(ex, ey));
            }
        }

        // 적군 잡고 게임 진행 맵에 표시
        for (Pos pos : enemyPosition) {
            gameMap[pos.x][pos.y] = 0;
        }
        return enemyPosition.size(); // 잡은 수 반환

    }

    // 궁수 위치 선정 mC3
    static void selelctArcher(int idx, int cnt) {
        if (cnt == 3) { // 3명 선택
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                if (selected[i]) {
                    path.add(i);
                }
            }
            archerList.add(path);
            return;
        }

        for (int i = idx; i < M; i++) {
            if (!selected[i]) {
                selected[i] = true;
                selelctArcher(i + 1, cnt + 1);
                selected[i] = false;
            }
        }
    }

    // 거리 계산
    static int getDistance(int r1, int c1, int r2, int c2) {
        return (Math.abs(r1 - r2) + Math.abs(c1 - c2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        gameMap = new int[N][M];
        selected = new boolean[M];
        archerList = new ArrayList<>();
        answer = initEnemy = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    initEnemy++;
                }
            }
        }

        startGame();

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}