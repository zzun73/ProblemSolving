package baekjoon.silver.Num28238;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] course = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                course[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day1 = 1, day2 = 2;
        int maxAttend = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                int cur = 0;
                for (int k = 0; k < N; k++) {
                    if (course[k][i] == 1 && course[k][j] == 1) {
                        cur++;
                    }
                }
                if (maxAttend < cur) {
                    maxAttend = cur;
                    day1 = i;
                    day2 = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxAttend).append("\n");

        for (int i = 0; i < 5; i++) {
            sb.append(i == day1 || i == day2 ? "1 " : "0 ");
        }
        sb.setLength(sb.length() - 1);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}