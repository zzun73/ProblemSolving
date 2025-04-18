package baekjoon.silver.Num17204;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] visited;

    static int helper() {
        int cur = 0;
        int result = 0;
        while (!visited[cur]) {
            if (cur == K) {
                return result;
            }

            visited[cur] = true;
            cur = arr[cur];

            result++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}