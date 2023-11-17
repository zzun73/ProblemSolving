package swea.d2.Num01288;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[10];

            int loop = 1;
            while (true) {
                int cur = N * loop;
                while (cur > 0) {
                    visited[cur % 10] = true;
                    cur /= 10;
                }

                boolean check = true;
                for (boolean v : visited) {
                    if (!v) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    break;
                }
                loop++;
            }

            sb.append("#").append(t).append(" ").append(loop * N).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}