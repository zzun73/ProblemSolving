package leetcode.easy.Num1431;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answer = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        for (int val : candies) {
            maxValue = Math.max(maxValue, val);
        }

        for (int val : candies) {
            answer.add(val + extraCandies >= maxValue);
        }

        return answer;
    }
}