package leetcode.easy.Num2389;

import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int index, sum;
        int answer[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            sum = index = 0;
            while (index < nums.length && sum + nums[index] <= queries[i]) {
                sum += nums[index++];
            }
            answer[i] = index;
        }

        return answer;
    }
}