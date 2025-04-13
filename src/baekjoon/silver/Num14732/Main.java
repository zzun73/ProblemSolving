package baekjoon.silver.Num14732;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[501][501];
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    map[i][j] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 500; i++) {
            for (int j = 0; j <= 500; j++) {
                answer += map[i][j] ? 1 : 0;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
