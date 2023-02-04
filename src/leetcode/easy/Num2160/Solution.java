package leetcode.easy.Num2160;

import java.util.Arrays;

class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        int result = 0;
        for (int i = 0; i < 4; i++) {
            arr[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(arr);
        result = (arr[0] * 10 + arr[2]) + (arr[1] * 10 + arr[3]);

        return result;
    }
}
