package programmers.level1.Num12932;

class Solution {
    public int[] solution(long n) {
        char[] input = String.valueOf(n).toCharArray();
        int[] answer = new int[input.length];
        int idx = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            answer[idx++] = input[i] - '0';
        }
        return answer;
    }
}