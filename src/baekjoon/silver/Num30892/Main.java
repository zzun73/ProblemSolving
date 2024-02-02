package baekjoon.silver.Num30892;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K; // N: 상어 마릿수, K: 먹을 수 있는 최대 마릿수
    static long T; // T: 샼의 최초 크기
    static PriorityQueue<Long> prev, next;

    // 자신의 크기보다 작은 상어는 전부 먹을 수 있다 (자신 크기 이상은 먹지 못함)
    // 잡아먹으면 그 크기만큼 커짐
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        prev = new PriorityQueue<>(Collections.reverseOrder()); // 먹을 수 있는 상어들
        next = new PriorityQueue<>(); // 먹을 수 없는 상어들

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            long sharkSize = Long.parseLong(st.nextToken());
            if (sharkSize >= T) {
                next.add(sharkSize);
            } else {
                prev.add(sharkSize);
            }
        }

        // 먹을 수 있는 상어들이 존재하며 먹을 수 있는 횟수도 남았을 경우
        while (K-- > 0 && !prev.isEmpty()) {
            long cur = prev.poll();
            T += cur; // 샼이 상어 먹기

            // 샼의 크기 반영하여 상어위치 최신화
            while (!next.isEmpty() && T > next.peek()) {
                prev.add(next.poll());
            }
        }
        bw.write(String.valueOf(T));

        br.close();
        bw.close();
    }
}
