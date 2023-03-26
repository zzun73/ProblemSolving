package leetcode.easy.Num1816;

import java.util.StringTokenizer;

class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ");

        while (k-- > 0) {
            sb.append(st.nextToken()).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}