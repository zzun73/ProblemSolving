package leetcode.easy.Num1967;

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int answer = 0;
        for (String str : patterns) {
            if (word.contains(str)) {
                answer++;
            }
        }
        return answer;
    }
}
