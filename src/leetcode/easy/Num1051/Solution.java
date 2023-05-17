package leetcode.easy.Num1051;

import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int answer = 0;
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                answer++;
            }
        }
        return answer;
    }
}