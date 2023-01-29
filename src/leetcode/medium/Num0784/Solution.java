package leetcode.medium.Num0784;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<String> answer;
    static int len;

    public List<String> letterCasePermutation(String s) {
        answer = new ArrayList<>();
        len = s.length();
        helper(s, new StringBuilder(), 0, 0);
        return answer;
    }

    public void helper(String s, StringBuilder path, int i, int depth) {

        if (depth == len) {
            answer.add(path.toString());
            return;
        }

        char ch = s.charAt(i);
        if (Character.isDigit(ch)) {
            helper(s, path.append(ch), i + 1, depth + 1);
            path.setLength(path.length() - 1);
        } else {
            helper(s, path.append(Character.toLowerCase(ch)), i + 1, depth + 1);
            path.setLength(path.length() - 1);
            helper(s, path.append(Character.toUpperCase(ch)), i + 1, depth + 1);
            path.setLength(path.length() - 1);
        }

    }
}
