package leetcode.easy.Num2144;

import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int answer = 0;
        for (int i = cost.length - 1; i >= 2; i -= 3) {
            int cur = cost[i] + cost[i - 1];
            answer += cur;
        }

        int rest = cost.length % 3;
        int index = 0;
        while (rest != index) {
            answer += cost[index++];
        }
        return answer;

    }
}