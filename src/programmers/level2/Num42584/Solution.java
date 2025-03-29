package programmers.level2.Num42584;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!deque.isEmpty() && prices[i] < prices[deque.peekLast()]) {
                int top = deque.pollLast();
                answer[top] = i - top;
            }
            deque.add(i);
        }

        while (!deque.isEmpty()) {
            int top = deque.pollLast();
            answer[top] = prices.length - 1 - top;
        }

        return answer;
    }
}