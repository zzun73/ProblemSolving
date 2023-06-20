package leetcode.easy.Num2496;

class Solution {
    public int maximumValue(String[] strs) {
        int answer = Integer.MIN_VALUE;
        for (String str : strs) {
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) >= 'a' && str.charAt(j) <= 'z') {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                answer = Math.max(answer, str.length());
            } else {
                answer = Math.max(answer, Integer.parseInt(str));
            }
        }
        return answer;
    }
}