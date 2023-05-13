package leetcode.easy.Num2566;

class Solution {
    public int minMaxDifference(int num) {
        String str = String.valueOf(num);
        int idx = 0;
        while (idx < str.length() - 1) {
            if (str.charAt(idx) != '9') {
                break;
            }
            idx++;
        }
        String maxValue = str.replace(str.charAt(idx), '9');
        String minValue = str.replace(str.charAt(0), '0');

        int answer = Integer.parseInt(maxValue) - Integer.parseInt(minValue);
        return answer;
    }
}