package programmers.level2.Num131701;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int[] arr = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = elements[i];
            arr[i + elements.length] = elements[i];
        }

        int size = 1;
        while (size <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < i + size; j++) {
                    sum += arr[j];
                }
                set.add(sum);
            }
            size++;
        }

        return set.size();
    }
}
