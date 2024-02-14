package baekjoon.gold.Num06987;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_GAME_COUNT = 15;
    static int[][] matches, results;
    //라운드 별 경기 팀 번호(인덱스)
    static int[] teamA = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] teamB = new int[]{1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    static boolean isGameOver;

    static void helper(int depth) {
        if (depth == MAX_GAME_COUNT) { // 15게임 진행했을 경우 (6C2)
            isGameOver = Arrays.deepEquals(matches, results); // 모든 값 0인지 확인
            return;
        }

        int A = teamA[depth];
        int B = teamB[depth];

        //A 승, B 패
        if (matches[A][0] > 0 && matches[B][2] > 0) {
            matches[A][0]--;
            matches[B][2]--;
            helper(depth + 1);
            matches[A][0]++;
            matches[B][2]++;
        }

        //A 무, B 무
        if (matches[A][1] > 0 && matches[B][1] > 0) {
            matches[A][1]--;
            matches[B][1]--;
            helper(depth + 1);
            matches[A][1]++;
            matches[B][1]++;
        }

        //A 패, B 승
        if (matches[A][2] > 0 && matches[B][0] > 0) {
            matches[A][2]--;
            matches[B][0]--;
            helper(depth + 1);
            matches[A][2]++;
            matches[B][0]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        matches = new int[6][3];
        results = new int[6][3]; // 결과 값 0인지 확인할 배열

        for (int t = 0; t < 4; t++) {
            isGameOver = false;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < matches.length; i++) {
                for (int j = 0; j < matches[i].length; j++) {
                    matches[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            helper(0);

            sb.append(isGameOver ? 1 : 0).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
