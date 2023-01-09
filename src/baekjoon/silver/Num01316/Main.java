package baekjoon.silver.Num01316;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean helper() throws IOException {
        boolean[] visited = new boolean[26];
        int prev = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i);

            if (prev != cur) {
                if (!visited[cur - 'a']) {
                    visited[cur - 'a'] = true;
                    prev = cur;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (helper()) {
                answer++;
            }
        }

        System.out.print(answer);
    }
}