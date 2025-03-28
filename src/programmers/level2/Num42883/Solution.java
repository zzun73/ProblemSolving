package programmers.level2.Num42883;

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (Character ch : number.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && ch > deque.peekLast()) {
                deque.pollLast();
                k--;
            }
            deque.addLast(ch);
        }

        while (k-- > 0) {
            deque.pollLast();
        }


        for (Character ch : deque) {
            sb.append(ch);
        }

        return sb.toString();
    }
}