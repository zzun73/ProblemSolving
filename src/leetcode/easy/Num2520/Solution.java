package leetcode.easy.Num2520;

class Solution {
    public int countDigits(int num) {

        int answer = 0;
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - '0';
            if (num % val == 0) {
                answer++;
            }
        }

        return answer;
    }
}