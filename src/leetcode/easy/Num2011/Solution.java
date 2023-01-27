package leetcode.easy.Num2011;

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int answer = 0;
        for (int i = 0; i < operations.length; i++) {
            String str = operations[i];
            if (str.indexOf('+') != -1) {
                answer++;
            } else {
                answer--;
            }
        }

        return answer;
    }
}