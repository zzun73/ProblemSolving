package leetcode.hard.Num1402;

import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int answer = 0;
        int cur = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            cur += satisfaction[i];
            if (cur < 0) {
                break;
            }
            answer += cur;
        }
        return answer;
    }
}