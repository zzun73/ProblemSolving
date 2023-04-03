package leetcode.easy.Num2578;

import java.util.Arrays;

class Solution {
    public int splitNum(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        Arrays.sort(ch);
        int[] arr = new int[2];
        for (int i = 0; i < ch.length; i++) {
            arr[i % 2] *= 10;
            arr[i % 2] += ch[i] - '0';
        }
        return arr[0] + arr[1];
    }
}