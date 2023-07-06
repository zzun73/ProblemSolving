package baekjoon.silver.Num02210;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static HashSet<String> answer;
    static StringBuilder sb;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void helper(int x, int y, int depth) {
        if (depth == 6) {
            answer.add(sb.toString());
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > arr.length - 1 || ny < 0 || ny > arr.length - 1) {
                continue;
            }
            sb.append(arr[nx][ny]);
            helper(nx, ny, depth + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        arr = new int[5][5];
        answer = new HashSet<>();
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                helper(i, j, 0);
            }
        }
        bw.write(answer.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
