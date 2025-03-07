package programmers.level2.Num138476;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int key : tangerine) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int sum = 0;
        int answer = 0;

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            answer++;
            sum += list.get(i);
            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}