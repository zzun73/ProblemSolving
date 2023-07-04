package baekjoon.silver.Num02606;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static boolean[] visited;
    public static int answer;

    public static void helper(int start) {
        if (visited[start]) {
            return;
        }
        answer++;
        visited[start] = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[start][i] == 1 && !visited[i]) {
                helper(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        int V = Integer.parseInt(br.readLine());
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        answer = -1;
        helper(1);

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }
}
