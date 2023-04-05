package leetcode.medium.Num2442;

import java.util.HashSet;

class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            StringBuilder sb = new StringBuilder();
            sb.append(num).reverse();
            set.add(Integer.parseInt(sb.toString()));
        }
        return set.size();
    }
}