package programmers.level2.Num142085;

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for (int val : enemy) {
            pq.add(val);
            n -= val;

            if (n < 0) {
                if (k <= 0) {
                    break;
                }
                n += pq.poll();
                k--;
            }
            answer++;
        }

        return answer;
    }
}