package baekjoon.silver.Num14472;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int answer = 0;
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '.') {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= D) {
                    answer++;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == '.') {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= D) {
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}