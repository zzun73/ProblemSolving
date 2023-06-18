package leetcode.easy.Num2710;

class Solution {
    public String removeTrailingZeros(String num) {
        int idx = num.length();
        while (num.charAt(--idx) == '0') {
        }
        return num.substring(0, idx + 1);
    }
}