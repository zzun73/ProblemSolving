package leetcode.easy.Num2078;

class Solution {
    public int maxDistance(int[] colors) {
        int answer = 0;
        int len = colors.length;
        for (int i = 0; i < len; i++) {
            if (colors[i] != colors[len - 1]) {
                answer = Math.max(answer, len - 1 - i);
            }
            if (colors[i] != colors[0]) {
                answer = Math.max(answer, i);
            }
        }
        return answer;
    }
}