package leetcode.medium.Num0491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    static List<List<Integer>> answer;
    static List<Integer> path;

    public List<List<Integer>> findSubsequences(int[] nums) {
        answer = new ArrayList<>();
        path = new ArrayList<>();
        helper(0, nums);
        return answer;
    }

    public static void helper(int start, int[] nums) {
        if (path.size() > 1) {
            answer.add(new ArrayList<>(path));
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if ((path.size() >= 1 && path.get(path.size() - 1) > nums[i]) || set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            helper(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
