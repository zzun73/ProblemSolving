package programmers.level2.Num84512;

import java.util.*;

class Solution {
    public int solution(String word) {
        int len = word.length();
        char[] ch = word.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);

        int[] weight = new int[5];
        int base = 1;
        for (int i = weight.length - 1; i >= 0; i--) {
            weight[i] = base;
            base = base * 5 + 1;
        }

        int answer = 0;
        for (int i = 0; i < len; i++) {
            answer += map.get(ch[i]) * weight[i] + 1;
        }

        return answer;
    }
}