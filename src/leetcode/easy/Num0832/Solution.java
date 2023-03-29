package leetcode.easy.Num0832;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        int row = image.length;
        int col = image[0].length;
        int[][] answer = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                answer[i][j] = image[i][col - j - 1];
                answer[i][j] ^= 1;
            }
        }
        return answer;
    }
}