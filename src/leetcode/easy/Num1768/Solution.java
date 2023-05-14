package leetcode.easy.Num1768;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        StringBuilder sb = new StringBuilder();
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < len1 || idx2 < len2) {
            if (idx1 < len1) {
                sb.append(word1.charAt(idx1++));
            }
            if (idx2 < len2) {
                sb.append(word2.charAt(idx2++));
            }
        }

        return sb.toString();
    }
}
