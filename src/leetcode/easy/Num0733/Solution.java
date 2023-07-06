package leetcode.easy.Num0733;

class Solution {
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public void helper(int[][] image, int x, int y, int curColor, int newColor) {

        visited[x][y] = true;
        image[x][y] = newColor;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > image.length - 1 || ny < 0 || ny > image[nx].length - 1 || visited[nx][ny]) {
                continue;
            }
            if (image[nx][ny] == curColor) {
                helper(image, nx, ny, curColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];
        helper(image, sr, sc, image[sr][sc], color);
        return image;
    }
}