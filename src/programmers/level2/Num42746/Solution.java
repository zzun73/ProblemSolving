package programmers.level2.Num42746;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        String[] strs = new String[len];

        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}