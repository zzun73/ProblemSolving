package leetcode.medium.Num1338;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        ArrayList<Integer> keySetList = new ArrayList<>(map.keySet());
        keySetList.sort((o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        int total = arr.length;
        int answer = 0;
        for (Integer key : keySetList) {
            int val = map.get(key);
            answer++;
            total -= val;
            if (total <= arr.length / 2) {
                break;
            }
        }
        return answer;
    }
}