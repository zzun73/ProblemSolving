package leetcode.easy.Num2678;

class Solution {
    public int countSeniors(String[] details) {
        int answer = 0;

        for (String str : details) {
            answer += Integer.parseInt(str.substring(11, 13)) > 60 ? 1 : 0;
        }
        return answer;
    }
}