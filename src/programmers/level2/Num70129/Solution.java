package programmers.level2.Num70129;

class Solution {
    public int[] solution(String s) {
        int prevLen = s.length();
        int[] answer = new int[2];
        while (!s.equals("1")) {
            s = s.replaceAll("0", "");
            answer[0]++;
            answer[1] += prevLen - s.length();

            s = Integer.toBinaryString(s.length());
            prevLen = s.length();
        }

        return answer;
    }
}