package leetcode.easy.Num1365;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] answer = new int[nums.length];
        int[] count = new int[102];

        for (int num : nums) {
            count[num + 1]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i] = count[nums[i]];
        }
        return answer;
    }
}