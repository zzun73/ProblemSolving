package leetcode.medium.Num0921;

import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    answer++;
                } else {
                    stack.pop();
                }
            }
        }
        return answer + stack.size();
    }
}