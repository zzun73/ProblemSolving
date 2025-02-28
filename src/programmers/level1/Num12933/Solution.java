package programmers.level1.Num12933;

import java.util.*;

class Solution {
    public long solution(long n) {

        char[] word = String.valueOf(n).toCharArray();
        Arrays.sort(word);

        StringBuilder sb = new StringBuilder();
        for (char ch : word) {
            sb.append(ch);
        }

        return Long.parseLong(sb.reverse().toString());
    }
}