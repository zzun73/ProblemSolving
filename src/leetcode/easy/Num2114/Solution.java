package leetcode.easy.Num2114;

import java.util.StringTokenizer;

class Solution {
    public int mostWordsFound(String[] sentences) {
        int answer = 0;
        for (int i = 0; i < sentences.length; i++) {
            StringTokenizer st = new StringTokenizer(sentences[i], " ");
            answer = Math.max(st.countTokens(), answer);
        }
        return answer;
    }
}