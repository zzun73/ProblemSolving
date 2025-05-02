package programmers.level2.Num131704;

import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> deque = new ArrayDeque<>();
        int answer = 0;
        int idx = 0;

        for (int box = 1; box <= order.length; box++) {
            deque.addLast(box);

            while (!deque.isEmpty() && deque.peekLast() == order[idx]) {
                deque.pollLast();
                idx++;
                answer++;
            }
        }

        return answer;
    }
}