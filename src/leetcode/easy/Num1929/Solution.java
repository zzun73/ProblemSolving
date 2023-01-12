package leetcode.easy.Num1929;

class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] answer = new int[nums.length * 2];
        System.arraycopy(nums, 0, answer, 0, nums.length);
        System.arraycopy(nums, 0, answer, nums.length, nums.length);
        return answer;

    }
}