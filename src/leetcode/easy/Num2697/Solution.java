package leetcode.easy.Num2697;

class Solution {
    public String makeSmallestPalindrome(String s) {
        int len = s.length();
        char[] ch = s.toCharArray();
        int i = 0, j = len - 1;
        while (i < j) {
            char minChar = (char) Math.min(ch[i], ch[j]);
            ch[i++] = minChar;
            ch[j--] = minChar;
        }
        return new String(ch);
    }
}