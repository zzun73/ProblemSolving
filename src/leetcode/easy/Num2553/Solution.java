package leetcode.easy.Num2553;

class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        char[] input = sb.toString().toCharArray();
        int[] answer = new int[input.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = input[i] - '0';
        }
        return answer;
    }
}