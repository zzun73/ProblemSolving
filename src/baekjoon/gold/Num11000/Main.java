package baekjoon.gold.Num11000;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] lecture = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lecture[i][0] = start;
            lecture[i][1] = end;
        }

        Arrays.sort(lecture, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(lecture[0][1]);
        for (int i = 1; i < N; i++) {
            if (queue.peek() <= lecture[i][0]) {
                queue.poll();
            }
            queue.offer(lecture[i][1]);
        }

        bw.write(queue.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
