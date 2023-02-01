package leetcode.easy.Num1528;

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] answer = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            answer[indices[i]] = s.charAt(i);
        }
        return String.valueOf(answer);
    }
}