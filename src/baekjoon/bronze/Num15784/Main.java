package baekjoon.bronze.Num15784;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] X = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                X[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int me = X[a][b];
        boolean angry = false;

        for (int i = 1; i <= N; i++) {
            if (X[i][b] > me || X[a][i] > me) {
                angry = true;
                break;
            }
        }

        bw.write(angry ? "ANGRY" : "HAPPY");

        br.close();
        bw.close();
    }
}