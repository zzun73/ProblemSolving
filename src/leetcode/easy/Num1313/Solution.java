package leetcode.easy.Num1313;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int index = 0;
        int[] answer = new int[len];
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            while (freq-- > 0) {
                answer[index++] = val;
            }
        }
        return answer;
    }
}