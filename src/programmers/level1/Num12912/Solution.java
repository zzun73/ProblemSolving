package programmers.level1.Num12912;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int n1 = Math.min(a, b);
        int n2 = Math.max(a, b);

        while (n1 <= n2) {
            answer += n1++;
        }
        return answer;
    }
}