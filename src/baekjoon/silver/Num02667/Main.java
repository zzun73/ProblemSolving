package baekjoon.silver.Num02667;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] arr;
    static int N;
    static int count;

    public static void helper(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > N - 1 || arr[x][y] == 0) {
            return;
        }
        arr[x][y] = 0;
        count++;
        helper(x + 1, y);
        helper(x - 1, y);
        helper(x, y + 1);
        helper(x, y - 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = ch[j] - '0';
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (arr[i][j] != 0) {
                    helper(i, j);
                    answer.add(count);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        Collections.sort(answer);
        for (Integer val : answer) {
            sb.append(val).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
