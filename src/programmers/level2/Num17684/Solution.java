package programmers.level2.Num17684;

import java.util.*;

class Solution {
    public int[] solution(String msg) {

        int value = 1;
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(Character.toString(ch), value++);
        }

        int start = 0;
        while (start < msg.length()) {
            int end = start;

            while (end + 1 < msg.length() && map.containsKey(msg.substring(start, end + 1))) {
                end++;
            }

            answerList.add(map.get(msg.substring(start, end)));

            if (end < msg.length()) {
                map.put(msg.substring(start, end + 1), value++);
            }
            start = end;
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}