package leetcode.easy.Num0434;

class Solution {
    public int countSegments(String s) {
        String[] str = s.split(" ");
        int answer = 0;
        for (String a : str) {
            if (!a.equals("")) {
                answer++;
            }
        }
        return answer;
    }
}