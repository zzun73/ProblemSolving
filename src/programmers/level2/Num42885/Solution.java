package programmers.level2.Num42885;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0, end = people.length - 1;

        while (start <= end) {
            int sum = people[start] + people[end];
            if (sum > limit) {
                end--;
                answer++;
            } else {
                start++;
                end--;
                answer++;
            }

        }

        return answer;
    }
}