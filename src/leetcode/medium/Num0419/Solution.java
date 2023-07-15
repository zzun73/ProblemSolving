package leetcode.medium.Num0419;

class Solution {
    static int[] dx = new int[]{1, 0};
    static int[] dy = new int[]{0, 1};

    public void helper(int x, int y, char[][] board) {
        board[x][y] = '.';

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > board.length - 1 || ny < 0 || ny > board[0].length - 1 || board[nx][ny] == '.') {
                continue;
            }
            helper(nx, ny, board);
        }
    }

    public int countBattleships(char[][] board) {

        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    helper(i, j, board);
                    answer++;
                }
            }
        }
        return answer;
    }
}