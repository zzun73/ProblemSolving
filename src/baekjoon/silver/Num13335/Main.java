package baekjoon.silver.Num13335;

import java.io.*;
import java.util.*;

public class Main {
    static int n, w, L; // n: 다리를 건너는 트럭의 수, w: 다리의 길이, L: 다리의 최대 하중
    static int sum, time, idx; // sum: 다리 위에 있는 트럭 무게 합, time: 모든 트럭이 다리를 다 건넌 시간 idx: 다리를 다 건넌 트럭의 무게를 빼주기 위한 위치값
    static Deque<Integer> trucks, bridges;
    static int[] weights;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        trucks = new ArrayDeque<>();
        bridges = new ArrayDeque<>();
        weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            trucks.add(weights[i]);
        }

        sum = time = idx = 0;

        while (!trucks.isEmpty()) {
            time++;

            int len = bridges.size();
            while (len-- > 0) { // 모든 다리 1칸씩 전진
                int cur = bridges.pollFirst() - 1;
                if (cur <= 0) {
                    sum -= weights[idx++]; // 다 건넌 트럭의 무게 제거
                    continue;
                }
                bridges.addLast(cur);
            }

            // 트럭 추가해도 하중 견딜 수 있으며, 다리 위로 이동할 칸 있는 경우
            if (sum + trucks.peek() <= L && bridges.size() + 1 <= w) {
                sum += trucks.poll();
                bridges.add(w); // 트럭 태우기
            }
        }
        bw.write(String.valueOf(time + w));

        br.close();
        bw.close();
    }
}

