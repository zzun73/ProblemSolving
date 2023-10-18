package baekjoon.silver.Num14646;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[2 * N];
        boolean[] visited = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;
        int count = 0;
        for (int i = 0; i < 2 * N; i++) {
            input[i] = Integer.parseInt(st.nextToken()) - 1;
            if (visited[input[i]]) {
                count--;
            } else {
                count++;
                visited[input[i]] = true;
            }
            answer = Math.max(answer, count);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}