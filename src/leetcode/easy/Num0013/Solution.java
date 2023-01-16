package leetcode.easy.Num0013;

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int answer = 0;
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            char cur = s.charAt(i);
            char next = s.charAt(i + 1);
            int curValue = map.get(cur);
            int nextValue = map.get(next);

            if (curValue < nextValue) {
                answer -= curValue;
            } else {
                answer += curValue;
            }
        }
        answer += map.get(s.charAt(length - 1));
        return answer;
    }
}