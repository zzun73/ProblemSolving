package programmers.level2.Num42583;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> deque = new ArrayDeque<>();

        int time = 0;
        int curWeight = 0;
        int index = 0;

        for (int i = 0; i < bridge_length; i++) {
            deque.add(0);
        }

        while (index < truck_weights.length) {
            time++;

            curWeight -= deque.poll();

            if (curWeight + truck_weights[index] <= weight) {
                deque.add(truck_weights[index]);
                curWeight += truck_weights[index++];
            } else {
                deque.add(0);
            }
        }

        return time + bridge_length;
    }
}