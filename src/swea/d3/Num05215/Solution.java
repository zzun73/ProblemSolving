package swea.d3.Num05215;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int N, L;
    static int answer = 0;
    static int[][] ingredients;
    static boolean[] checked;

    public static void helper(int index, int curCal, int curVal) {
        answer = Math.max(answer, curVal);
        for (int i = index; i < N; i++) {
            if (!checked[i] && ingredients[i][1] + curCal <= L) {
                checked[i] = true;
                helper(i, curCal + ingredients[i][1], curVal + ingredients[i][0]);
                checked[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            ingredients = new int[N][2];
            checked = new boolean[N];
            answer = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                ingredients[i][0] = A;
                ingredients[i][1] = B;
            }
            helper(0, 0, 0);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}