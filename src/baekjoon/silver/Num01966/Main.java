package baekjoon.silver.Num01966;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int answer = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                boolean flag = true;

                for (int[] val : queue) {
                    if (cur[1] < val[1]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                    if (cur[0] == M) {
                        break;
                    }
                } else {
                    queue.offer(cur);
                }
            }

            bw.write(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
