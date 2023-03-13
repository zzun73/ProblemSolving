package leetcode.easy.Num1844;

class Solution {
    public String replaceDigits(String s) {
        char[] answer = s.toCharArray();
        for (int i = 1; i < s.length(); i += 2) {
            answer[i] = (char) (s.charAt(i) + s.charAt(i - 1) - '0');
        }

        return new String(answer);
    }
}
