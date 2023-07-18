package leetcode.easy.Num0136;

class Solution {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int val : nums) {
            answer ^= val;
        }
        return answer;
    }
}