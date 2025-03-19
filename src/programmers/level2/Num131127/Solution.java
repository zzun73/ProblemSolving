package programmers.level2.Num131127;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<String, Integer> targetMap, curMap;

    static boolean isMatch() {
        for (String key : targetMap.keySet()) {
            if (curMap.getOrDefault(key, 0) < targetMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        targetMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            targetMap.put(want[i], number[i]);
        }

        curMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            curMap.put(discount[i], curMap.getOrDefault(discount[i], 0) + 1);
        }

        if (isMatch()) {
            answer++;
        }

        for (int i = 10; i < discount.length; i++) {
            String prevItem = discount[i - 10];
            if (curMap.get(prevItem) == 1) {
                curMap.remove(prevItem);
            } else {
                curMap.put(prevItem, curMap.get(prevItem) - 1);
            }

            String newItem = discount[i];
            curMap.put(newItem, curMap.getOrDefault(newItem, 0) + 1);

            if (isMatch()) {
                answer++;
            }
        }

        return answer;
    }
}