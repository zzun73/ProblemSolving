package leetcode.medium.Num0540;

class Solution {
    public int singleNonDuplicate(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i++] != nums[i]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }
}