package baekjoon.gold.Num03055;

import java.io.*;
import java.util.*;

class Pos {
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int R, C;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static char[][] boardW, boardS;
    static int[][] visitedW, visitedS;
    static Queue<Pos> qW = new LinkedList<>();
    static Queue<Pos> qS = new LinkedList<>();

    private static void helperW() {

        while (!qW.isEmpty()) {
            Pos cur = qW.poll();

            for (int i = 0; i < dx.length; i++) {
                Pos nPos = new Pos(cur.x + dx[i], cur.y + dy[i]);
                int nx = nPos.x;
                int ny = nPos.y;
                if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1 || visitedW[nx][ny] != 0
                        || boardW[nx][ny] == 'X' || boardW[nx][ny] == 'D') {
                    continue;
                }

                visitedW[nx][ny] = visitedW[cur.x][cur.y] + 1;
                qW.add(nPos);
            }
        }
    }

    private static int helperS(Pos start, Pos end) {
        qS.add(start);
        visitedS[start.x][start.y] = 1;

        while (!qS.isEmpty()) {
            Pos cur = qS.poll();

            for (int i = 0; i < dx.length; i++) {
                Pos nPos = new Pos(cur.x + dx[i], cur.y + dy[i]);
                int nx = nPos.x;
                int ny = nPos.y;
                if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1
                        || boardS[nx][ny] == 'X' || boardS[nx][ny] == '*'
                        || (visitedS[cur.x][cur.y] + 1 >= visitedW[nx][ny] && visitedW[nx][ny] != 0)) {
                    continue;
                }
                if (nx == end.x && ny == end.y) {
                    return visitedS[cur.x][cur.y];
                }

                visitedS[nx][ny] = visitedS[cur.x][cur.y] + 1;
                qS.add(nPos);
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        boardW = new char[R][C];
        boardS = new char[R][C];
        visitedW = new int[R][C];
        visitedS = new int[R][C];

        Pos start;
        Pos end;
        start = end = null;

        for (int i = 0; i < R; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                boardS[i][j] = ch[j];
                boardW[i][j] = ch[j];

                if (ch[j] == 'S') {
                    start = new Pos(i, j);
                } else if (ch[j] == 'D') {
                    end = new Pos(i, j);

                } else if (ch[j] == '*') {
                    qW.add(new Pos(i, j));
                    visitedW[i][j] = 1;
                }
            }
        }
        helperW();
        int answer = helperS(start, end);

        if (answer == -1) {
            bw.write("KAKTUS");
        } else {
            bw.write(answer + "");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}
