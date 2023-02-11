package leetcode.easy.Num1974;

class Solution {
    public int minTimeToType(String word) {
        int answer = word.length();
        char prev = 'a';
        for (int i = 0; i < word.length(); ++i) {
            char cur = word.charAt(i);
            int diff = Math.abs(cur - prev);
            answer += Math.min(diff, 26 - diff);
            prev = cur;
        }
        return answer;
    }
}