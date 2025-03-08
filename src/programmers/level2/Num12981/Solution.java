package programmers.level2.Num12981;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int turn = 0;
        Set<String> set = new HashSet<>();
        while (turn * n < words.length) {
            for (int i = turn * n; i < turn * n + n; i++) {

                if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) || set.contains(words[i])) {
                    return new int[]{i % n + 1, turn + 1};
                }

                set.add(words[i]);
            }

            turn++;
        }

        return new int[]{0, 0};
    }
}
