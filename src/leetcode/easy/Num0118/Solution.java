package leetcode.easy.Num0118;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            path.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    path.add(1);
                } else {
                    path.add(answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));
                }
            }
            answer.add(new ArrayList<>(path));
        }
        return answer;
    }
}