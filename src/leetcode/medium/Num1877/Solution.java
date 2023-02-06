package leetcode.medium.Num1877;

import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int max = Integer.MIN_VALUE;
        while (start < end) {
            max = Math.max(max, nums[start++] + nums[end--]);
        }
        return max;
    }
}