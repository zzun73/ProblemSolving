package programmers.level2.Num12909;

import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                deque.add('(');
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                deque.poll();
            }
        }

        return deque.isEmpty();
    }
}