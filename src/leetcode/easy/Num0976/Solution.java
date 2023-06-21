package leetcode.easy.Num0976;

import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                answer += nums[i] + nums[i - 1] + nums[i - 2];
                break;
            }
        }
        return answer;
    }
}