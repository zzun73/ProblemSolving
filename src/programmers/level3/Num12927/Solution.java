package programmers.level3.Num12927;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : works) {
            pq.add(val);
        }

        while (n-- > 0 && pq.peek() > 0) {
            pq.add(pq.poll() - 1);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int val = pq.poll();
            answer += (long) val * val;
        }

        return answer;
    }
}