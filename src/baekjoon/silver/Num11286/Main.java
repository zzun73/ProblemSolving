package baekjoon.silver.Num11286;

import java.io.*;
import java.util.*;

public class Main {
    static int N, command;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1 == -o2) { // 절댓값이 같은 경우
            return o1 < 0 ? -1 : 1; // o1이 음수라면 swap x, o1이 양수라면 swap o
        }
        return Math.abs(o1) - Math.abs(o2); // 절댓값이 다른 경우
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            command = Integer.parseInt(br.readLine());
            if (command == 0) { // 정렬 기준에 맞게 제거 & 출력 (pq 비어있으면 0 출력)
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
                continue;
            }

            pq.add(command); // pq에 값 추가
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}