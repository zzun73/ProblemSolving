package swea.d3.Num01873;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int T, H, W, N, x, y, nx, ny, next, dir;
    static char[][] map;
    static String str;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int getDir(char ch) {
        if (ch == '^') { // 위쪽
            return 0;
        } else if (ch == 'v') { // 아래쪽
            return 1;
        } else if (ch == '<') { // 왼쪽
            return 2;
        } else if (ch == '>') { // 오른쪽
            return 3;
        }
        return -1;
    }

    static boolean isIn(int x, int y) { // 맵 범위 내인지
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); // 높이 = 행
            W = Integer.parseInt(st.nextToken()); // 너비 = 열
            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    //시작위치
                    if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }


            N = Integer.parseInt(br.readLine());
            str = br.readLine(); // 사용자 입력

            dir = getDir(map[x][y]); // 현재방향

            for (int i = 0; i < N; i++) {
                char input = str.charAt(i);

                switch (input) {
                    case 'U': {
                        dir = 0; // 바라보는 방향 위쪽으로 변경
                        map[x][y] = '^';
                        nx = x + dx[dir];
                        ny = y + dy[dir];

                        if (isIn(nx, ny) && map[nx][ny] == '.') { // 위쪽으로 이동 가능하며 평지일 경우 1칸 이동
                            map[nx][ny] = '^';
                            map[x][y] = '.';
                            x = nx;
                            y = ny;
                        }

                        break;
                    }
                    case 'D': {
                        dir = 1; // 바라보는 방향 아래쪽으로 변경
                        map[x][y] = 'v';
                        nx = x + dx[dir];
                        ny = y + dy[dir];

                        if (isIn(nx, ny) && map[nx][ny] == '.') { // 아래쪽으로 이동 가능하며 평지일 경우 1칸 이동
                            map[nx][ny] = 'v';
                            map[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        break;
                    }
                    case 'L': {
                        dir = 2; // 바라보는 방향 왼쪽으로 변경
                        map[x][y] = '<';
                        nx = x + dx[dir];
                        ny = y + dy[dir];

                        if (isIn(nx, ny) && map[nx][ny] == '.') { // 왼쪽으로 이동 가능하며 평지일 경우 1칸 이동
                            map[nx][ny] = '<';
                            map[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        break;
                    }
                    case 'R': {
                        dir = 3; // 바라보는 방향 오른쪽으로 변경
                        map[x][y] = '>';
                        nx = x + dx[dir];
                        ny = y + dy[dir];

                        if (isIn(nx, ny) && map[nx][ny] == '.') { // 오른쪽으로 이동 가능하며 평지일 경우 1칸 이동
                            map[nx][ny] = '>';
                            map[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        break;
                    }
                    case 'S': { // 바라보는 방향으로 포탄 발사
                        nx = x;
                        ny = y;

                        while (isIn(nx, ny)) {
                            nx += dx[dir];
                            ny += dy[dir];
                            if (isIn(nx, ny)) { // 맵 밖으로 나가기 전까지
                                next = map[nx][ny];
                                if (next == '*') { // 벽돌로 만들어진 벽
                                    map[nx][ny] = '.'; // 벽 파괴후 평지로 만들고 종료
                                    break;
                                } else if (next == '#') { // 강철로 만들어진 벽
                                    break; // 아무일 없이 종료
                                }
                            } else { // 맵 밖으로 나가면 종료
                                break;
                            }
                        }
                        break;
                    }
                    default:
                        break;
                }
            }


            sb.append("#").append(t).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}