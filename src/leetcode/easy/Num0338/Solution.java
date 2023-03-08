package leetcode.easy.Num0338;

import java.util.Arrays;

class Solution {
    static int[] memo;

    public int[] countBits(int n) {
        memo = new int[n + 1];
        if (n <= 1) {
            for (int i = 0; i <= n; i++) {
                memo[i] = i;
            }
            return memo;
        }

        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 0; i <= n; i++)
            memo[i] = helper(i);
        return memo;
    }

    public int helper(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n % 2 == 0) {
            return memo[n] = helper(n / 2);
        } else {
            return memo[n] = helper(n / 2) + 1;
        }
    }
}