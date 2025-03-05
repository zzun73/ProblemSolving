package programmers.level2.Num12924;

class Solution {
    public int solution(int n) {
        int a = 1, b = 1, sum = 1;
        int answer = 0;
        while (a <= b && b <= n) {
            if (sum == n) {
                sum -= a;
                a++;
                answer++;
            } else if (sum < n) {
                b++;
                sum += b;
            } else if (sum > n) {
                sum -= a;
                a++;
            }
        }

        return answer;
    }
}