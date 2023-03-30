package leetcode.easy.Num1859;

class Solution {
    public String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] answer = new String[str.length];
        for (String word : str) {
            int num = word.length() - 1;
            answer[word.charAt(num) - '1'] = word.substring(0, num);
        }
        return String.join(" ", answer);
    }
}