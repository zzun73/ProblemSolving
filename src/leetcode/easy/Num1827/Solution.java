package leetcode.easy.Num1827;

class Solution {
    public int minOperations(int[] nums) {

        int diff, answer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                diff = (nums[i - 1] - nums[i]) + 1;
                nums[i] += diff;
                answer += diff;
            }
        }
        return answer;
    }
}