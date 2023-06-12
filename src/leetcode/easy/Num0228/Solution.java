package leetcode.easy.Num0228;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start != nums[i]) {
                sb.append(start).append("->").append(nums[i]);
                answer.add(sb.toString());
            } else {
                sb.append(start);
                answer.add(sb.toString());
            }
            sb.setLength(0);
        }
        return answer;
    }
}