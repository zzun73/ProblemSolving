package programmers.level1.Num42840;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        Deque<Integer> one = new ArrayDeque<>(List.of(1, 2, 3, 4, 5));
        Deque<Integer> two = new ArrayDeque<>(List.of(2, 1, 2, 3, 2, 4, 2, 5));
        Deque<Integer> three = new ArrayDeque<>(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        int[] score = new int[3];

        for (int answer : answers) {
            score[0] += one.peekFirst() == answer ? 1 : 0;
            score[1] += two.peekFirst() == answer ? 1 : 0;
            score[2] += three.peekFirst() == answer ? 1 : 0;

            one.addLast(one.pollFirst());
            two.addLast(two.pollFirst());
            three.addLast(three.pollFirst());
        }

        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            max = Math.max(max, score[i]);
        }

        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}