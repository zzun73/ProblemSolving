package leetcode.medium.Num1557;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] checked = new boolean[n];
        for (List<Integer> edge : edges) {
            checked[edge.get(1)] = true;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < checked.length; i++) {
            if (!checked[i]) {
                answer.add(i);
            }
        }

        return answer;
    }
}