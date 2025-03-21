package programmers.level2.Num42586;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        Queue<Integer> deque = new ArrayDeque<>();

        for (int val : progresses) {
            deque.add(val);
        }

        int d = 0;
        while (!deque.isEmpty()) {
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                } else {
                    if (day[i] == 0) {
                        day[i] = d;
                        deque.poll();
                    }
                }
            }
            d++;
        }

        List<Integer> list = new ArrayList<>();
        int cur = day[0];
        for (int i = 0; i < day.length; i++) {
            int idx = i + 1;
            int count = 0;
            while (idx < day.length && day[i] >= day[idx]) {
                count++;
                idx++;
            }
            i += count;
            list.add(count + 1);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}