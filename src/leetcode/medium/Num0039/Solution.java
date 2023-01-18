package leetcode.medium.Num0039;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> answer;
    static List<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList();
        path = new ArrayList();
        helper(0, candidates, target, 0);
        return answer;
    }

    public static void helper(int depth, int[] candidates, int target, int sum) {
        if (target == sum) {
            answer.add(new ArrayList(path));
            return;
        }

        for (int i = depth; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                path.add(candidates[i]);
                helper(i, candidates, target, sum + candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}