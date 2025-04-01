package programmers.level2.Num64065;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2);
        s = s.substring(0, s.length() - 2);
        String[] str = s.replace("},{", " ").split(" ");
        Arrays.sort(str, Comparator.comparingInt(String::length));

        int[] answer = new int[str.length];
        Set<Integer> set = new HashSet<>();

        for (String cur : str) {
            for (String number : cur.split(",")) {
                int val = Integer.parseInt(number);
                if (!set.contains(val)) {
                    answer[set.size()] = val;
                    set.add(val);
                }
            }
        }

        return answer;
    }
}
