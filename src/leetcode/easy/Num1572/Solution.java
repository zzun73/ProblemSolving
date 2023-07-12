package leetcode.easy.Num1572;

class Solution {
    public int diagonalSum(int[][] mat) {
        int answer = 0;
        int len = mat.length;
        for (int i = 0; i < len; i++) {
            if (i != len - i - 1) {
                answer += mat[i][i] + mat[i][len - i - 1];
            } else {
                answer += mat[i][i];
            }
        }
        return answer;
    }
}