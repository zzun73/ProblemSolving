package leetcode.easy.Num2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int val : nums1) {
            set1.add(val);
        }
        for (int val : nums2) {
            set2.add(val);
        }
        List<List<Integer>> answer = new ArrayList<>(2);
        helper(set1, set2, answer, new ArrayList<>());
        helper(set2, set1, answer, new ArrayList<>());

        return answer;
    }

    private static void helper(HashSet<Integer> set1, HashSet<Integer> set2, List<List<Integer>> answer, List<Integer> path) {
        for (int val : set1) {
            if (!set2.contains(val)) {
                path.add(val);
            }
        }
        answer.add(new ArrayList<>(path));
    }
}