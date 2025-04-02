package programmers.level2.Num49993;

import java.util.*;

class Solution {
    static Map<Character, Integer> map;

    boolean helper(String skill_tree) {
        int prev = 0;

        for (char ch : skill_tree.toCharArray()) {
            if (map.containsKey(ch)) {
                int cur = map.get(ch);
                if (cur != prev + 1) {
                    return false;
                }
                prev++;
            }
        }

        return true;
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        map = new HashMap<>();

        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i + 1);
        }

        for (String skill_tree : skill_trees) {
            if (helper(skill_tree)) {
                answer++;
            }
        }

        return answer;
    }
}
