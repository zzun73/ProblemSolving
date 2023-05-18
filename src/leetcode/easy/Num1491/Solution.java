package leetcode.easy.Num1491;

import java.util.Arrays;

class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double answer = 0.0;
        for (int i = 1; i < salary.length - 1; i++) {
            answer += salary[i];
        }
        return answer / (salary.length - 2);
    }
}