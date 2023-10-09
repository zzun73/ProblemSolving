package baekjoon.silver.Num02563;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0, size = 10;
        int N = Integer.parseInt(br.readLine());
        boolean[][] grid = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            for (int x = startX; x < startX + size; x++) {
                for (int y = startY; y < startY + size; y++) {
                    if (!grid[x][y]) {
                        grid[x][y] = true;
                        answer++;
                    }
                }
            }
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}