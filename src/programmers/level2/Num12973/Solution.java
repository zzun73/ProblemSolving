package programmers.level2.Num12973;

import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char word : s.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast() == word) {
                deque.pollLast();
            } else {
                deque.addLast(word);
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        return deque.isEmpty() ? 1 : 0;
    }
}