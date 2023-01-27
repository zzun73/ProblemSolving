package leetcode.easy.Num1221;

class Solution {
    public int balancedStringSplit(String s) {
        int l_cnt = 0, r_cnt = 0, answer = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'L') {
                l_cnt++;
            } else {
                r_cnt++;
            }

            if (l_cnt != 0 && l_cnt == r_cnt)
                answer++;
        }

        return answer;
    }
}