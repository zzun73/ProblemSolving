package leetcode.easy.Num1342;

class Solution {
    public int numberOfSteps(int num) {
        int answer = 0;

        while (num != 0) {
            answer++;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
        }
        return answer;
    }
}