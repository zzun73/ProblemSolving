package baekjoon.gold.Num02344;

import java.io.*;
import java.util.*;

public class Main {
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] reflect = new int[]{3, 2, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> holes = new ArrayList<>();
        List<Integer> directions = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            holes.add(new int[]{i, 0});
            directions.add(3); // 우
        }
        for (int j = 1; j <= M; j++) {
            holes.add(new int[]{N + 1, j});
            directions.add(0); // 상
        }

        for (int i = N; i >= 1; i--) {
            holes.add(new int[]{i, M + 1});
            directions.add(2); // 좌
        }
        for (int j = M; j >= 1; j--) {
            holes.add(new int[]{0, j});
            directions.add(1); //하
        }


        for (int i = 0; i < holes.size(); i++) {
            int d = directions.get(i);
            int x = holes.get(i)[0] + dx[d];
            int y = holes.get(i)[1] + dy[d];

            while (true) {
                if (map[x][y] == 1) {
                    d = reflect[d];
                }

                if (x == 0 || x == N + 1 || y == 0 || y == M + 1) {
                    for (int j = 0; j < holes.size(); j++) {
                        if (holes.get(j)[0] == x && holes.get(j)[1] == y) {
                            sb.append(j + 1).append(" ");
                            break;
                        }
                    }
                    break;
                }

                x += dx[d];
                y += dy[d];
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
