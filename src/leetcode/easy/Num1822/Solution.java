package leetcode.easy.Num1822;

class Solution {
    public int arraySign(int[] nums) {
        int answer = 1;
        for (int val : nums) {
            int cur = val > 0 ? 1 : (val < 0 ? -1 : 0);
            answer *= cur;
            if (answer == 0) {
                break;
            }
        }
        return answer;
    }
}