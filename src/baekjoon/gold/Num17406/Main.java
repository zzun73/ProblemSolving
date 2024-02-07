package baekjoon.gold.Num17406;

import java.io.*;
import java.util.*;

class Info {
    int r, c, s;

    public Info(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

public class Main {
    static int N, M, K, temp;
    static int[][] arr;
    static Info[] infos;
    static List<Integer> path;
    static boolean[] visited;
    static int answer;

    static void helper(int[][] brr, int r, int c, int s) {
        int depth = -1;

        for (int posX = r - s, posY = c - s; posX < r && posY < c; posX++, posY++) {
            depth++;

            temp = brr[posX][c + s - depth];

            // 우 (윗 줄)
            for (int j = c + s - depth; j > posY; j--) {
                brr[posX][j] = brr[posX][j - 1];
            }

            // 상 (왼쪽 줄)
            for (int i = posX; i < r + s - depth; i++) {
                brr[i][posY] = brr[i + 1][posY];
            }

            // 왼 (아랫 줄)
            for (int j = posY; j < c + s - depth; j++) {
                brr[r + s - depth][j] = brr[r + s - depth][j + 1];
            }

            // 하 (오른쪽 줄)
            for (int i = r + s - depth; i > posX; i--) {
                brr[i][c + s - depth] = brr[i - 1][c + s - depth];
            }

            brr[posX + 1][c + s - depth] = temp;
        }
    }

    static void combi(int count) {
        if (count == K) {
            int[][] brr = new int[arr.length][arr[0].length];
            for (int i = 0; i < arr.length; i++) {
                System.arraycopy(arr[i], 0, brr[i], 0, arr[0].length);
            }

            for (int val : path) {
                helper(brr, infos[val].r, infos[val].c, infos[val].s);
            }

            for (int i = 1; i <= N; i++) {
                int rowSum = 0;
                for (int j = 1; j <= M; j++) {
                    rowSum += brr[i][j];
                }
                answer = Math.min(answer, rowSum);
            }
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(i);
                combi(count + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        infos = new Info[K];
        visited = new boolean[K];
        path = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            infos[i] = new Info(r, c, s);
        }

        answer = Integer.MAX_VALUE;
        combi(0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}