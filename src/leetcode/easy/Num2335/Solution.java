package leetcode.easy.Num2335;

import java.util.Arrays;

class Solution {
    public int fillCups(int[] amount) {

        Arrays.sort(amount);
        int x = amount[0];
        int y = amount[1];
        int z = amount[2];

        int answer;
        int sum = x + y + z;
        if (x + y > z) {
            answer = sum / 2 + sum % 2;
        } else {
            answer = z;
        }

        return answer;
    }
}