package leetcode.easy.Num0268;

class Solution {
    public int missingNumber(int[] nums) {
        int[] pos = new int[nums.length + 1];
        for (int num : nums) {
            pos[num]++;
        }

        int answer = 0;
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}