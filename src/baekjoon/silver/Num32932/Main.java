package baekjoon.silver.Num32932;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] block = new boolean[1001][1001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) + 500;
            int y = Integer.parseInt(st.nextToken()) + 500;
            block[y][x] = true;
        }

        int cx = 500, cy = 500;
        for (char command : br.readLine().toCharArray()) {
            int ny = cy, nx = cx;
            if (command == 'U') {
                ny += 1;
            } else if (command == 'D') {
                ny -= 1;
            } else if (command == 'R') {
                nx += 1;
            } else if (command == 'L') {
                nx -= 1;
            }

            if (ny < 0 || ny > 1000 || nx < 0 || nx > 1000 || block[ny][nx]) {
                continue;
            }
            cy = ny;
            cx = nx;
        }
        sb.append(cx - 500).append(" ").append(cy - 500);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}