package programmers.level2.Num154538;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];

        deque.add(new int[]{x, 0});
        visited[x] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int value = current[0];
            int step = current[1];

            if (value == y) {
                return step;
            }

            for (int next : new int[]{value + n, value * 2, value * 3}) {
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    deque.add(new int[]{next, step + 1});
                }
            }
        }

        return -1;
    }
}