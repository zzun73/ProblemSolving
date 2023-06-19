package leetcode.easy.Num1732;

class Solution {
    public int largestAltitude(int[] gain) {
        int cur = 0;
        int answer = 0;
        for (int val : gain) {
            cur += val;
            answer = Math.max(answer, cur);
        }
        return answer;
    }
}