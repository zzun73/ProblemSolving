package leetcode.easy.Num0009;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int origin = x, reverse = 0, temp;

        while (x > 0) {
            temp = x % 10;
            reverse = (10 * reverse) + temp;
            x /= 10;
        }

        return reverse == origin;
    }
}