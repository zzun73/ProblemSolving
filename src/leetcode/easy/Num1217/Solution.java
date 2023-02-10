package leetcode.easy.Num1217;

class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int pos : position) {
            if (pos % 2 == 1) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }
}