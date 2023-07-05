package leetcode.medium.Num0797;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> answer;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(0, graph, path);
        return answer;
    }

    public void helper(int start, int[][] graph, List<Integer> path) {
        if (start == graph.length - 1) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for (int val : graph[start]) {
            path.add(val);
            helper(val, graph, path);
            path.remove(path.size() - 1);
        }
    }
}