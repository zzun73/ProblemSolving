package programmers.level2.Num42586;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < progresses.length; i++){
            int cur = progresses[i];
            int day = 0;
            while( cur < 100){
                cur += speeds[i];
                day++;
            }
            deque.addLast(day);
        }

        while(!deque.isEmpty()){
            int count = 1;
            int cur = deque.pollFirst();
            while(!deque.isEmpty() && deque.peekFirst() <= cur){
                count++;
                deque.pollFirst();
            }
            list.add(count);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}