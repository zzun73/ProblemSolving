package programmers.level1.Num1845;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }

        return Math.min(set.size(), nums.length / 2);
    }
}