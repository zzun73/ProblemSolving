package leetcode.easy.Num1710;

import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);

        int answer = 0;
        for (int[] boxType : boxTypes) {
            int count = boxType[0];
            int weight = boxType[1];
            if (truckSize >= count) {
                answer += weight * count;
                truckSize -= count;
            } else {
                answer += weight * truckSize;
                break;
            }
        }

        return answer;
    }
}