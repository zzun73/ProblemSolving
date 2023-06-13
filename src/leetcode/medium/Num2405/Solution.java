package leetcode.medium.Num2405;

import java.util.HashSet;

class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int answer = 1;
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            if (set.contains(word)) {
                answer++;
                set.clear();
            }
            set.add(word);
        }
        return answer;
    }
}