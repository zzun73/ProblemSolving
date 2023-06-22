package leetcode.easy.Num2652;

class Solution {
    public int sumOfMultiples(int n) {
        int num = 1;
        int answer = 0;
        while (num <= n) {
            if (num % 3 == 0 || num % 5 == 0 || num % 7 == 0) {
                answer += num;
            }
            num++;
        }
        return answer;
    }
}