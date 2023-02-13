package baekjoon.silver.Num01158;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        sb.append("<");
        while (queue.size() != 1) {
            int index = 1;
            while (index != K) {
                int val = queue.poll();
                queue.offer(val);
                index++;
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
