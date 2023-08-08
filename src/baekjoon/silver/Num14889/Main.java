package baekjoon.silver.Num14889;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int N, answer;

    public static void helper(int depth, int start) {
        if (answer == 0) {
            return;
        }
        if (depth == N / 2) {
            int[] teamA = new int[N / 2];
            int[] teamB = new int[N / 2];
            int idxA, idxB, sumA, sumB;
            sumA = sumB = idxA = idxB = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    teamA[idxA++] = i;
                } else {
                    teamB[idxB++] = i;
                }
            }

            for (int i = 0; i < N / 2; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    sumA += (arr[teamA[i]][teamA[j]] + arr[teamA[j]][teamA[i]]);
                    sumB += (arr[teamB[i]][teamB[j]] + arr[teamB[j]][teamB[i]]);
                }
            }
            answer = Math.min(answer, Math.abs(sumA - sumB));
            return;
        }

        for (int i = start + 1; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        helper(0, 0);

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
