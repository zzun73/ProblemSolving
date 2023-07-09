package baekjoon.silver.Num01697;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int answer;
    static boolean[] visited = new boolean[100001];
    static Queue<int[]> q = new LinkedList<>();

    public static void helper(int value) {
        insertAndMark(value, 0);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curVal = cur[0];
            int curDepth = cur[1];

            if (curVal == K) {
                answer = curDepth;
                break;
            }

            if (isValid(curVal + 1)) {
                insertAndMark(curVal + 1, curDepth + 1);
            }
            if (isValid(curVal - 1)) {
                insertAndMark(curVal - 1, curDepth + 1);
            }
            if (isValid(curVal * 2)) {
                insertAndMark(curVal * 2, curDepth + 1);
            }
        }
    }

    private static void insertAndMark(int curVal, int curDepth) {
        q.add(new int[]{curVal, curDepth});
        visited[curVal] = true;
    }

    private static boolean isValid(int curVal) {
        return curVal >= 0 && curVal < visited.length && !visited[curVal];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = 0;
        helper(N);

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
