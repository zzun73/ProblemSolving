package leetcode.easy.Num2544;

class Solution {
    public int alternateDigitSum(int n) {
        String str = String.valueOf(n);
        int answer = 0;
        for (int i = 0; i < str.length(); i += 2) {
            answer += str.charAt(i) - '0';
        }
        for (int i = 1; i < str.length(); i += 2) {
            answer -= str.charAt(i) - '0';
        }
        return answer;
    }
}