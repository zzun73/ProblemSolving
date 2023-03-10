package leetcode.easy.Num0509;

class Solution {
    static int[] fibo;

    public int fib(int n) {
        fibo = new int[31];
        return helper(n);
    }

    public int helper(int n) {
        if (n <= 1) {
            return n;
        }
        if (fibo[n] != 0) {
            return fibo[n];
        } else {
            return fibo[n] = helper(n - 1) + helper(n - 2);
        }
    }
}