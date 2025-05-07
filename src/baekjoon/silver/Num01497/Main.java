package baekjoon.silver.Num01497;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxPlay, answer;
    static boolean[][] played;
    static boolean[] choice;

    static void helper(int idx, int count) {
        int playCount = countPlayable();
        if (playCount > maxPlay) {
            maxPlay = playCount;
            answer = count;
        } else if (playCount == maxPlay) {
            answer = Math.min(answer, count);
        }

        for (int i = idx; i < N; i++) {
            if (!choice[i]) {
                choice[i] = true;
                helper(i + 1, count + 1);
                choice[i] = false;
            }
        }
    }

    static int countPlayable() {
        boolean[] result = new boolean[M];
        for (int i = 0; i < N; i++) {
            if (!choice[i]) continue;
            for (int j = 0; j < M; j++) {
                result[j] |= played[i][j];
            }
        }
        int cnt = 0;
        for (boolean b : result) {
            if (b) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        played = new boolean[N][M];
        choice = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            String input = st.nextToken();
            for (int j = 0; j < M; j++) {
                played[i][j] = input.charAt(j) == 'Y';
            }
        }

        answer = Integer.MAX_VALUE;
        maxPlay = -1;

        helper(0, 0);

        bw.write(String.valueOf(maxPlay == 0 ? -1 : answer));
        br.close();
        bw.close();
    }
}