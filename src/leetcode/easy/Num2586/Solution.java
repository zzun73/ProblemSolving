package leetcode.easy.Num2586;

class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int answer = 0;
        String vowel = "aeiou";
        for (int i = left; i <= right; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if (vowel.indexOf(start) != -1 && vowel.indexOf(end) != -1) {
                answer++;
            }
        }
        return answer;
    }
}