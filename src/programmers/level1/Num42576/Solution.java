package programmers.level1.Num42576;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String in : participant) {
            map.put(in, map.getOrDefault(in, 0) + 1);
        }

        for (String out : completion) {
            if (map.getOrDefault(out, 0) == 1) {
                map.remove(out);
            } else {
                map.put(out, map.get(out) - 1);
            }
        }

        for (String fail : map.keySet()) {
            answer = fail;
        }

        return answer;
    }
}