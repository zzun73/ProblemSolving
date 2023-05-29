package leetcode.easy.Num1837;

class Solution {
    public int sumBase(int n, int k) {
        int answer = 0;
        while (n >= k) {
            answer += n % k;
            n /= k;
        }
        return answer + n;
    }
}