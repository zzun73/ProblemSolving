package programmers.level2.Num42578;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;
        for (String[] str : clothes) {
            map.put(str[1], map.getOrDefault(str[1], 1) + 1);
        }

        for (int val : map.values()) {
            answer *= val;
        }
        return answer - 1;
    }
}