package leetcode.easy.Num2032;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        boolean[][] count = new boolean[3][101];
        for (int i : nums1) {
            count[0][i] = true;
        }
        for (int i : nums2) {
            count[1][i] = true;
        }
        for (int i : nums3) {
            count[2][i] = true;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if ((count[0][i] & count[1][i]) | (count[0][i] & count[2][i]) | (count[1][i] & count[2][i])) {
                answer.add(i);
            }
        }
        return answer;
    }
}
