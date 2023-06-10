package leetcode.easy.Num2706;

import java.util.Arrays;

class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int sum = prices[0] + prices[1];
        int answer = money - sum;
        return answer >= 0 ? answer : money;
    }
}