package baekjoon.silver.Num02799;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String star = "****";
        int[] answer = new int[5];

        while (M-- > 0) {
            br.readLine();
            int[][] cnt = new int[N][5];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine(), "#");
                for (int j = 0; j < N; j++) {
                    if (st.nextToken().equals(star)) {
                        cnt[j][i]++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                int cur = 0;
                for (int j = 0; j < 4; j++) {
                    cur += cnt[i][j];
                }
                answer[cur]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : answer) {
            sb.append(val).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
