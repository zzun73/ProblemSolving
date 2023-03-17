package leetcode.easy.Num1748;

import java.util.HashMap;

class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int answer = 0;

        for (int val : nums) {
            if (map.get(val) == 1) {
                answer += val;
            }
        }

        return answer;
    }
}