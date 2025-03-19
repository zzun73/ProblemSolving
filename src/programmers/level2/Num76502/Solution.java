package programmers.level2.Num76502;

import java.util.*;

class Solution {
    public int solution(String s) {
        Map<Character, Character> map = Map.of(
                ')', '(',
                ']', '[',
                '}', '{');
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            Deque<Character> deque = new ArrayDeque<>();
            s = s.substring(1) + s.charAt(0);
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (map.containsValue(c)) {
                    deque.add(c);
                } else if (!deque.isEmpty() && deque.peekLast() == map.get(c)) {
                    deque.pollLast();
                } else {
                    flag = false;
                    break;
                }
            }
            if (deque.isEmpty() && flag) {
                answer++;
            }
        }
        return answer;
    }
}