package leetcode.easy.Num1733;

import java.util.List;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        String[] rule = new String[]{"type", "color", "name"};
        int findIndex = 0;
        for (int i = 0; i < 3; i++) {
            if (rule[i].equals(ruleKey)) {
                findIndex = i;
                break;
            }
        }
        int answer = 0;
        for (List<String> path : items) {
            if (path.get(findIndex).equals(ruleValue)) {
                answer++;
            }
        }
        return answer;
    }
}