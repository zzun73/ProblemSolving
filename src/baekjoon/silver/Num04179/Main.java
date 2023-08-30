package baekjoon.silver.Num04179;

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
    static int R, C;
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
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || board[nx][ny] == '#' || board[nx][ny] == 'm' || times[nx][ny] != Integer.MAX_VALUE) {
                    continue;
                }
                times[nx][ny] = fireCur.time + 1;
                board[nx][ny] = 'm';
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

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || board[nx][ny] == '#' || board[nx][ny] == 'F' || board[nx][ny] == '1' || personCur.time >= times[nx][ny]) {
                    continue;
                }
                board[nx][ny] = '1';
                person.add(new Pos(nx, ny, personCur.time + 1));
            }
        }

        return -1;
    }

    private static boolean isEdge(int x, int y, int time) {
        return (x == 0 || x == R - 1 || y == 0 || y == C - 1) && time < times[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        times = new int[R][C];
        person = new ArrayDeque<>();
        fire = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = input[j];

                if (input[j] == 'J') {
                    person.add(new Pos(i, j, 0));
                } else if (input[j] == 'F') {
                    board[i][j] = 'm';
                    times[i][j] = 0;
                    fire.add(new Pos(i, j, 0));
                }
            }
        }

        int answer = helper();
        bw.write(answer == -1 ? "IMPOSSIBLE" : String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
