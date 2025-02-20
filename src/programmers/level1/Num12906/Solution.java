package programmers.level1.Num12906;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] solution(int[] arr) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (deque.peekLast() == arr[i]) {
                continue;
            }
            deque.add(arr[i]);
        }


        int[] answer = new int[deque.size()];
        int idx = 0;
        while (!deque.isEmpty()) {
            answer[idx++] = deque.pollFirst();
        }

        return answer;
    }
}