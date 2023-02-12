package leetcode.easy.Num2224;

class Solution {
    public int convertTime(String current, String correct) {
        int[] time = new int[]{1, 5, 15, 60};
        String[] cur = current.split(":");
        String[] ans = correct.split(":");

        int curTime = Integer.parseInt(cur[0]) * 60 + Integer.parseInt(cur[1]);
        int ansTime = Integer.parseInt(ans[0]) * 60 + Integer.parseInt(ans[1]);
        int diffTime = ansTime - curTime;

        int answer = 0;
        for (int i = time.length - 1; i >= 0; i--) {
            if (diffTime / time[i] > 0) {
                answer += diffTime / time[i];
                diffTime %= time[i];
            }
        }

        return answer;
    }
}