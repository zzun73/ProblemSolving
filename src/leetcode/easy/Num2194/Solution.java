package leetcode.easy.Num2194;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        char startAlpabet = s.charAt(0);
        int startValue = s.charAt(1) - '0';
        char endAlpabet = s.charAt(3);
        int endValue = s.charAt(4) - '0';
        for (char ch = startAlpabet; ch <= endAlpabet; ch++) {
            for (int i = startValue; i <= endValue; i++) {
                list.add(String.valueOf(ch) + i);
            }
        }
        return list;
    }
}