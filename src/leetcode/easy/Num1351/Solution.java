package leetcode.easy.Num1351;

class Solution {
    public int countNegatives(int[][] grid) {
        int answer = 0;
        for (int[] arr : grid) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < 0) {
                    answer += arr.length - j;
                    break;
                }
            }
        }
        return answer;
    }
}