package leetcode.easy.Num0977;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(answer);
        return answer;
    }
}