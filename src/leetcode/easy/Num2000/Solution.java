package leetcode.easy.Num2000;

class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0, index + 1)).reverse().append(word.substring(index + 1));

        return sb.toString();
    }
}