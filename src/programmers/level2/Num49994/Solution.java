package programmers.level2.Num49994;

class Solution {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] reverseDir = new int[]{1, 0, 3, 2};

    static int helper(String dirs) {
        int result = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5, y = 5;
        int nx = 0, ny = 0;
        for (char command : dirs.toCharArray()) {
            int dir = 0;
            if (command == 'U') {
                dir = 0;
            } else if (command == 'D') {
                dir = 1;
            } else if (command == 'R') {
                dir = 2;
            } else if (command == 'L') {
                dir = 3;
            }


            nx = x + dx[dir];
            ny = y + dy[dir];
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                continue;
            }


            if (!visited[nx][ny][dir]) {
                visited[nx][ny][dir] = true;
                visited[x][y][reverseDir[dir]] = true;
                result++;
            }
            x = nx;
            y = ny;
        }

        return result;
    }

    public int solution(String dirs) {
        return helper(dirs);
    }
}