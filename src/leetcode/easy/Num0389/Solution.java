package leetcode.easy.Num0389;

class Solution {
    public char findTheDifference(String s, String t) {

        char[] tchar = t.toCharArray();
        char[] schar = s.toCharArray();
        char ch = 0;

        for (int i = 0; i < s.length(); i++) {
            ch += tchar[i];
            ch -= schar[i];
        }
        ch += tchar[t.length() - 1];
        return ch;
    }
}