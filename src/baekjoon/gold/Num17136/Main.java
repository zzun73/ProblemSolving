package baekjoon.gold.Num17136;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int MAP_SIZE = 10;

    static int answer;
    static int[][] map;
    static int[] count = new int[]{0, 5, 5, 5, 5, 5};

    static void helper(int x, int y, int cnt) {
        if (cnt == 0) {
            int sum = -5;
            for (int val : count) {
                sum += 5 - val;
            }
            answer = Math.min(sum, answer);
            return;
        }


        if (x >= MAP_SIZE) {
            return;
        }

        if (y >= MAP_SIZE) {
            helper(x + 1, 0, cnt);
            return;
        }

        if (map[x][y] == 1) {
            for (int i = count.length - 1; i >= 1; i--) {
                if (count[i] > 0 && check(x, y, i)) {
                    count[i]--;
                    changeToVal(x, y, i, 0);
                    helper(x, y + i, cnt - (i * i));
                    count[i]++;
                    changeToVal(x, y, i, 1);
                }
            }
        } else {
            helper(x, y + 1, cnt);
        }
    }

    static void changeToVal(int x, int y, int len, int val) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                map[i][j] = val;
            }
        }
    }

    static boolean check(int x, int y, int len) {
        // 범위 밖 체크
        if (x + len > MAP_SIZE || y + len > MAP_SIZE) {
            return false;
        }
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (map[i][j] == 0) { // 0이 적힌 칸에 색종이 붙일 수 없음
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        map = new int[MAP_SIZE][MAP_SIZE];
        int oneCount = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    oneCount++;
                }
            }
        }
        answer = Integer.MAX_VALUE;
        if (oneCount == 0) {
            answer = 0;
        } else if (oneCount == 100) {
            answer = 4;
        }
        helper(0, 0, oneCount);

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));
        br.close();
        bw.close();
    }
}