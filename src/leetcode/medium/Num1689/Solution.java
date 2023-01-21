package leetcode.medium.Num1689;

class Solution {
    public int minPartitions(String n) {
        int answer = 0;
        for (int i = 0; i < n.length(); i++) {
            int value = n.charAt(i) - '0';
            if (answer < value) {
                answer = value;
            }
            if (answer == 9) {
                break;
            }
        }
        return answer;
    }
}