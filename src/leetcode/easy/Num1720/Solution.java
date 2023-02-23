package leetcode.easy.Num1720;

class Solution {
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] answer = new int[len + 1];
        answer[0] = first;
        for (int i = 0; i < len; i++) {
            answer[i + 1] = encoded[i] ^ answer[i];
        }
        return answer;
    }
}