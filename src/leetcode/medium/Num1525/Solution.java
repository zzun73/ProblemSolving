package leetcode.medium.Num1525;

import java.util.HashSet;

class Solution {
    public int numSplits(String s) {
        HashSet<Character> setA = new HashSet<>();
        HashSet<Character> setB = new HashSet<>();
        int answer = 0;

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
            setB.add(ch);
        }

        for (char ch : s.toCharArray()) {
            setA.add(ch);
            count[ch - 'a']--;

            if (count[ch - 'a'] == 0) {
                setB.remove(ch);
            }

            if (setA.size() == setB.size()) {
                answer++;
            }
        }
        return answer;
    }
}