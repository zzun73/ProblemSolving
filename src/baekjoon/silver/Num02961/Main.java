package baekjoon.silver.Num02961;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[][] taste;

    public static void helper(int depth, boolean check, int S, int B) {
        if (depth == N) {
            if (check) {
                answer = Math.min(answer, Math.abs(S - B));
            }
            return;
        }

        helper(depth + 1, true, S * taste[depth][0], B + taste[depth][1]);
        helper(depth + 1, check, S, B);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            taste[i][0] = S;
            taste[i][1] = B;
        }

        helper(0, false, 1, 0);
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
