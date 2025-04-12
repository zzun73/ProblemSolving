package baekjoon.gold.Num17143;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M;
    static int answer; // 잡은 상어 크기의 합
    static int[] dx = new int[]{-1, 1, 0, 0}; // 상 하 우 좌
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] changeDir = new int[]{1, 0, 3, 2};
    static List<Integer>[][] sharkIndex;
    static Shark[] sharks;

    static class Shark implements Comparable<Shark> {
        int idx, x, y, s, d, z;

        public Shark(int idx, int x, int y, int s, int d, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            return o.z - this.z; // 크기 순 정렬 (동일 크기 없기에 다른 조건 필요 x)
        }

    }

    static void helper() {

        // 1열부터 차례대로 이동
        int kingY = 0;

        // 1단계 낚시왕 오른쪽 한 칸 이동
        while (++kingY <= C) {

            // 2단계 땅과 가장 가까운 상어 잡기(가장 먼저 발견 x 작은 순)
            // 잡았을 경우 해당 상어 null 처리 및 answer += 잡은 상어 크기
            catchShark(kingY);

            // 3단계 상어 이동하기
            // 격자 벗어나지 않고 반대로 이동하는 것도 처리
            moveSharks();

            // 4단계 같은 칸에 여러 상어 존재시 큰 상어만 남겨놓고 모두 null 처리
            eatSharks();
        }
    }

    static void catchShark(int kingY) {
        for (int i = 1; i <= R; i++) {
            if (!sharkIndex[i][kingY].isEmpty()) {
                answer += sharks[sharkIndex[i][kingY].get(0)].z;
                sharks[sharkIndex[i][kingY].get(0)] = null;
                sharkIndex[i][kingY].clear();
                break;
            }
        }
    }

    static void moveSharks() {
        // 이동 전 초기화
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                sharkIndex[i][j].clear();
            }
        }

        for (Shark shark : sharks) {
            if (shark == null) { // 제거된 상어 스킵
                continue;
            }
            int x = shark.x;
            int y = shark.y;
            int s = shark.s;
            int d = shark.d;

            if (d == 0 || d == 1) {
                s %= (R - 1) * 2;
            } else {
                s %= (C - 1) * 2;
            }

            for (int i = 0; i < s; i++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx <= 0 || nx > R || ny <= 0 || ny > C) {
                    d = changeDir[d];
                    nx = x + dx[d];
                    ny = y + dy[d];
                }

                x = nx;
                y = ny;
            }

            // 이동 결과 업데이트
            shark.x = x;
            shark.y = y;
            shark.d = d;
            sharkIndex[x][y].add(shark.idx);
        }
    }

    static void eatSharks() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (sharkIndex[i][j].size() > 1) {

                    // 동일 좌표에 위치한 상어들 찾기
                    List<Shark> findSharks = new ArrayList<>();
                    for (int idx : sharkIndex[i][j]) {
                        if (sharks[idx] != null) {
                            findSharks.add(sharks[idx]);
                        }
                    }
                    Collections.sort(findSharks);

                    // 큰 상어 제외 나머지 상어 제거
                    for (int k = 1; k < findSharks.size(); k++) {
                        sharks[findSharks.get(k).idx] = null;
                    }

                    // 위치 정보 업데이트
                    sharkIndex[i][j].clear();
                    sharkIndex[i][j].add(findSharks.get(0).idx);
                }
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
        M = Integer.parseInt(st.nextToken());

        answer = 0;
        sharks = new Shark[M + 1];
        sharkIndex = new ArrayList[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                sharkIndex[i][j] = new ArrayList<>();
            }
        }

        for (int idx = 1; idx <= M; idx++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1; // 0 based
            int z = Integer.parseInt(st.nextToken());

            sharks[idx] = new Shark(idx, x, y, s, d, z);
            sharkIndex[x][y].add(idx);
        }
        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
