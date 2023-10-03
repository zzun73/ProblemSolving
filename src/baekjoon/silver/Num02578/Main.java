package baekjoon.silver.Num02578;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static final int NUM = 5;

    private static boolean checked(int bingo) {
        return bingo >= 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] row = new int[NUM];
        int[] col = new int[NUM];
        int[] diagonal = new int[2];
        int answer = 0, bingo = 0;
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < NUM; j++) {
                int X = Integer.parseInt(st.nextToken());
                map.put(X, new int[]{i, j});
            }
        }

        for (int i = 0; i < NUM; i++) {
            if (checked(bingo)) break;
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < NUM; j++) {
                answer++;
                int X = Integer.parseInt(st.nextToken());
                int[] pos = map.get(X);
                row[pos[0]]++;
                col[pos[1]]++;

                if (row[pos[0]] == NUM) {
                    bingo++;
                }

                if (col[pos[1]] == NUM) {
                    bingo++;
                }

                if (pos[0] == pos[1]) {
                    diagonal[0]++;
                    if (diagonal[0] == NUM) {
                        bingo++;
                    }
                }

                if (pos[0] + pos[1] == NUM - 1) {
                    diagonal[1]++;
                    if (diagonal[1] == NUM) {
                        bingo++;
                    }
                }
                if (checked(bingo)) break;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}