package baekjoon.gold.Num14891;

import java.io.*;
import java.util.*;

class Gear {
    Deque<Character> deque;

    public Gear() {
        this.deque = new ArrayDeque<>();
    }
}

public class Main {
    private static final int SIZE = 4, LEFT = 2, RIGHT = 6;
    static int K;
    static Gear[] gears;
    static boolean[] visited;

    static void helper(int idx, int dir) {
        Object[] cur = gears[idx].deque.toArray();

        if (idx - 1 >= 0 && !visited[idx - 1]) { // 좌측 톱니바퀴 탐색
            Object[] left = gears[idx - 1].deque.toArray();

            if (cur[RIGHT] != left[LEFT]) {
                visited[idx - 1] = true;
                helper(idx - 1, dir * -1);
                visited[idx - 1] = false;
            }
        }
        if (idx + 1 < SIZE && !visited[idx + 1]) { // 우측 톱니바퀴 탐색
            Object[] right = gears[idx + 1].deque.toArray();

            if (cur[LEFT] != right[RIGHT]) {
                visited[idx + 1] = true;
                helper(idx + 1, dir * -1);
                visited[idx + 1] = false;
            }
        }

        rotate(idx, dir);
    }

    static void rotate(int idx, int dir) {
        if (dir == 1) { // 시계방향
            gears[idx].deque.addFirst(gears[idx].deque.removeLast());
        } else { // 반시계방향
            gears[idx].deque.addLast(gears[idx].deque.removeFirst());
        }
    }

    static int calcScore() {
        int sum = 0;
        for (int i = 0; i < gears.length; i++) {
            if (gears[i].deque.peek() == '1') { // 12시 방향이 1일 경우 점수 합산
                sum += Math.pow(2, i);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        gears = new Gear[SIZE];
        visited = new boolean[SIZE];
        for (int i = 0; i < gears.length; i++) {
            gears[i] = new Gear();

            for (char c : br.readLine().toCharArray()) {
                gears[i].deque.add(c);
            }
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken()) - 1; // 회전시킬 톱니바퀴 번호
            int dir = Integer.parseInt(st.nextToken()); // 1이면 시계방향 -1이면 반시계방향

            visited[idx] = true;
            helper(idx, dir);
            visited[idx] = false;
        }
        bw.write(String.valueOf(calcScore()));

        br.close();
        bw.close();
    }
}