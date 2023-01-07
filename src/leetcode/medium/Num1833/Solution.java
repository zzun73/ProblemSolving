package leetcode.medium.Num1833;

import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;

        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                coins -= costs[i];
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}
