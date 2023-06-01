package leetcode.easy.Num1684;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int answer = 0;
        boolean[] checked = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            checked[ch - 'a'] = true;
        }
        for (String word : words) {
            int cnt = 1;
            for (char ch : word.toCharArray()) {
                if (!checked[ch - 'a']) {
                    cnt = 0;
                    break;
                }
            }
            answer += cnt;
        }
        return answer;
    }
}