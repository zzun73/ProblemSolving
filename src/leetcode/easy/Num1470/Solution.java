package leetcode.easy.Num1470;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[nums.length];
        int xpos = 0, ypos = n;
        for (int i = 0; i < nums.length; i += 2) {
            answer[i] = nums[xpos++];
            answer[i + 1] = nums[ypos++];
        }

        return answer;
    }
}