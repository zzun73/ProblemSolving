package leetcode.easy.Num1295;

class Solution {
    public int findNumbers(int[] nums) {
        int answer = 0;
        for (int val : nums) {
            answer += String.valueOf(val).length() % 2 == 0 ? 1 : 0;
        }
        return answer;
    }
}