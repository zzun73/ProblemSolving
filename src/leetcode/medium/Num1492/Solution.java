package leetcode.medium.Num1492;

class Solution {
    public int kthFactor(int n, int k) {
        int i = 1;
        int answer = 0;
        while (i <= n) {
            if (n % i == 0) {
                answer++;
                if (answer == k) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}