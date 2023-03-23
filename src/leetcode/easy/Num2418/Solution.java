package leetcode.easy.Num2418;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String[] answer = new String[names.length];
        int index = 0;
        for (int i = names.length - 1; i >= 0; i--) {
            answer[index++] = map.get(heights[i]);
        }
        return answer;
    }
}