package leetcode.easy.Num0942;

class Solution {
    public int[] diStringMatch(String s) {
        int start = 0;
        int end = s.length(), len = s.length();
        int[] answer = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'I') {
                answer[i] = start++;
            } else {
                answer[i] = end--;
            }
        }
        answer[len] = end;
        return answer;
    }
}