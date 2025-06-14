package baekjoon.silver.Num01347;

import java.io.*;

public class Main {
    static int[] left = new int[]{3, 0, 1, 2};
    static int[] right = new int[]{1, 2, 3, 0};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[101][101];
        int x = 50, y = 50, dir = 2;
        int minX = x, maxX = x, minY = y, maxY = y;

        visited[x][y] = true;

        for (char command : br.readLine().toCharArray()) {
            if (command == 'L') {
                dir = left[dir];
            } else if (command == 'R') {
                dir = right[dir];
            } else if (command == 'F') {
                x += dx[dir];
                y += dy[dir];
                visited[x][y] = true;

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                sb.append(visited[i][j] ? '.' : '#');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}