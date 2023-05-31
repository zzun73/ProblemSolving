package leetcode.easy.Num1672;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int answer = 0;
        for (int[] num : accounts) {
            int sum = 0;
            for (int val : num) {
                sum += val;
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}