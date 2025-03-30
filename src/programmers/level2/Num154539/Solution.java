package programmers.level2.Num154539;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = numbers.length - 1; i >= 0; i--) {

            while (!deque.isEmpty() && numbers[deque.peekLast()] <= numbers[i]) {
                deque.pollLast();
            }
            answer[i] = deque.isEmpty() ? -1 : numbers[deque.peekLast()];
            deque.add(i);
        }

        return answer;
    }
}