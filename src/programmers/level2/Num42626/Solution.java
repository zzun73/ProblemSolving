package programmers.level2.Num42626;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : scoville) {
            pq.add(val);
        }

        while (pq.size() > 1 && pq.peek() < K) {
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }
        return pq.peek() >= K ? answer : -1;
    }
}