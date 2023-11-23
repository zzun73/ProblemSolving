package baekjoon.silver.Num15719;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N];
        int answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            if (!visited[cur]) {
                visited[cur] = true;
            } else {
                answer = cur;
                break;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}