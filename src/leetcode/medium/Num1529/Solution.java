package leetcode.medium.Num1529;

class Solution {
    public int minFlips(String target) {
        if (target.contains("1") == false) {
            return 0;
        }
        char[] word = target.toCharArray();
        int answer = 0;
        char prev = '0';

        for (char ch : word) {
            if (ch != prev) {
                prev = ch;
                answer++;
            }
        }

        return answer;
    }
}