package baekjoon.gold.Num05427;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pos {
    int x, y, time;

    public Pos(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    static int W, H;
    static char[][] board;
    static int[][] times;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static ArrayDeque<Pos> person, fire;

    public static int helper() {

        while (!fire.isEmpty()) {
            Pos fireCur = fire.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + fireCur.x;
                int ny = dy[i] + fireCur.y;
                if (nx < 0 || nx >= H || ny < 0 || ny >= W || board[nx][ny] == '#' || board[nx][ny] == 'f' || times[nx][ny] != Integer.MAX_VALUE) {
                    continue;
                }
                times[nx][ny] = fireCur.time + 1;
                board[nx][ny] = 'f';
                fire.add(new Pos(nx, ny, fireCur.time + 1));

            }
        }

        while (!person.isEmpty()) {
            Pos personCur = person.poll();
            if (isEdge(personCur.x, personCur.y, personCur.time)) {
                return personCur.time + 1;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + personCur.x;
                int ny = dy[i] + personCur.y;

                if (nx < 0 || nx >= H || ny < 0 || ny >= W || board[nx][ny] == '#' || board[nx][ny] == '*' || board[nx][ny] == 'p' || personCur.time >= times[nx][ny]) {
                    continue;
                }
                board[nx][ny] = 'p';
                person.add(new Pos(nx, ny, personCur.time + 1));
            }
        }

        return -1;
    }

    private static boolean isEdge(int x, int y, int time) {
        return (x == 0 || x == H - 1 || y == 0 || y == W - 1) && time < times[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            board = new char[H][W];
            times = new int[H][W];
            person = new ArrayDeque<>();
            fire = new ArrayDeque<>();

            for (int i = 0; i < H; i++) {
                Arrays.fill(times[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < H; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    board[i][j] = input[j];

                    if (input[j] == '@') {
                        person.add(new Pos(i, j, 0));
                    } else if (input[j] == '*') {
                        board[i][j] = 'f';
                        times[i][j] = 0;
                        fire.add(new Pos(i, j, 0));
                    }
                }
            }
            int answer = helper();
            sb.append(answer == -1 ? "IMPOSSIBLE" : answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
