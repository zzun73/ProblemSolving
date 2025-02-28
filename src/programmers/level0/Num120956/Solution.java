package programmers.level0.Num120956;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {
            str = str.replaceAll("aya|ye|ma|woo", "");
            if (str.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}