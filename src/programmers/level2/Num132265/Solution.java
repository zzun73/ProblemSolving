package programmers.level2.Num132265;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int key : topping) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            int key = topping[i];
            if (map.get(key) > 1) {
                map.put(key, map.get(key) - 1);
            } else {
                map.remove(key);
            }

            set.add(key);

            if (set.size() == map.size()) {
                answer++;
            }
        }

        return answer;
    }
}