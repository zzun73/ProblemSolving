package baekjoon.silver.Num14248;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void helper(int idx) {
        if (idx < 0 || idx > N - 1) {
            return;
        }
        if (visited[idx]) {
            return;
        }

        visited[idx] = true;
        helper(idx + arr[idx]);
        helper(idx - arr[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine()) - 1;
        helper(start);

        int answer = 0;
        for (boolean b : visited) {
            if (b) {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}