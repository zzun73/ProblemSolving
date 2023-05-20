package leetcode.easy.Num2315;

class Solution {
    public int countAsterisks(String s) {
        String[] str = s.split("\\|");
        int answer = 0;
        for (int i = 0; i < str.length; i += 2) {
            answer += str[i].chars()
                    .filter(c -> c == '*')
                    .count();
        }
        return answer;
    }
}