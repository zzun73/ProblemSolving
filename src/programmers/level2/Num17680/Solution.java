package programmers.level2.Num17680;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Set<String> set = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (set.contains(city)) {
                answer += 1;
                deque.remove(city);
                deque.addLast(city);
            } else {
                answer += 5;
                set.add(city);
                deque.addLast(city);

                if (set.size() > cacheSize) {
                    set.remove(deque.pollFirst());
                }
            }
        }

        return answer;
    }
}