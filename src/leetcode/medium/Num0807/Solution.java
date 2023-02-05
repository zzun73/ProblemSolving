package leetcode.medium.Num0807;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] rowMax = new int[len];
        int[] colMax = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int goal = Math.min(rowMax[i], colMax[j]);
                answer += goal - grid[i][j];
            }
        }
        return answer;
    }
}