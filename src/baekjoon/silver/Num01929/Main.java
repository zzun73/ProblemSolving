package baekjoon.silver.Num01929;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;

    public static void helper() {
        visited[1] = true;
        for (int i = 2; i < Math.sqrt(visited.length); i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = i * i; j < visited.length; j += i) {
                visited[j] = true;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        helper();

        for (int i = M; i <= N; i++) {
            if (!visited[i]) {
                bw.write(i + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}