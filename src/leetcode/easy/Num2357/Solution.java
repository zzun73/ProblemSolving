package leetcode.easy.Num2357;

import java.util.HashSet;

class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int val : nums) {
            if (val != 0) {
                set.add(val);
            }
        }

        return set.size();
    }
}
