package leetcode.easy.Num0401;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    static int[] time = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    static boolean[] visited = new boolean[10];
    HashSet<String> set = new HashSet<>();

    public List<String> readBinaryWatch(int turnedOn) {
        helper(0, 0, 0, turnedOn);
        return new ArrayList<>(set);
    }

    public void helper(int hour, int minute, int depth, int turnedOn) {
        if (depth == turnedOn) {
            String val;
            if (minute <= 9) {
                val = hour + ":" + "0" + minute;
            } else {
                val = hour + ":" + minute;
            }
            set.add(val);
            return;
        }

        for (int i = depth; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (i < 4 && hour + time[i] < 12) {
                    helper(hour + time[i], minute, depth + 1, turnedOn);
                }
                if (i >= 4 && minute + time[i] < 60) {
                    helper(hour, minute + time[i], depth + 1, turnedOn);
                }
                visited[i] = false;
            }
        }

    }
}