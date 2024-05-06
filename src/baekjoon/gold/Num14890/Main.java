package baekjoon.gold.Num14890;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, L, answer;
    static int[][] map, rotateMap;

    static int helper(int[] row) {
        int count = 1;

        for (int i = 1; i < N; i++) {
            int diff = row[i] - row[i - 1];
            if (Math.abs(diff) > 1) {
                return 0;
            }
            if (diff == 0) {
                count++;
            } else if (diff == 1 && count >= L) {
                count = 1;

            } else if (diff == -1 && count >= 0) {
                count = -L + 1;

            } else {
                return 0;
            }
        }

        return count >= 0 ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        answer = 0;
        map = new int[N][N];
        rotateMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = rotateMap[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            answer += helper(map[i]) + helper(rotateMap[i]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}