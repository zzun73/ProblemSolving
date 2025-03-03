package programmers.level2.Num12939;

import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        int[] arr = new int[str.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);

        sb.append(arr[0]).append(" ").append(arr[arr.length - 1]);

        return sb.toString();
    }
}