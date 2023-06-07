package leetcode.easy.Num1716;

class Solution {
    public int totalMoney(int n) {
        int answer = 0;
        int[] day = new int[]{1, 2, 3, 4, 5, 6, 7};
        int idx = 0;
        while (n > 0) {
            if (idx > 6) {
                idx = 0;
            }
            answer += day[idx];
            day[idx++]++;
            n--;
        }
        return answer;
    }
}