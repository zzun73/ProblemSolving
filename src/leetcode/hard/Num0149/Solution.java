package leetcode.hard.Num0149;

class Solution {
    //https://leetcode.com/problems/max-points-on-a-line/solutions/3017341/java-solution-with-explantation/?orderBy=most_votes&languageTags=java
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int ans = 2;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = 2;
                for (int k = j + 1; k < n; k++) { // 점i와 점k 사이의 기울기와 점i와 점j 사이의 기울기 비교
                    int x = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
                    int y = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);
                    if (x == y) {
                        temp++;
                    }
                }
                if (temp > ans) { //최대값 최신화
                    ans = temp;
                }
            }
        }
        return ans;
    }
}