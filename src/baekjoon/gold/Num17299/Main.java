package baekjoon.gold.Num17299;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!deque.isEmpty() && map.get(arr[i]) >= map.get(arr[deque.peekLast()])) {
                deque.pollLast();
            }
            if (!deque.isEmpty()) {
                answer[i] = arr[deque.peekLast()];
            } else {
                answer[i] = -1;
            }
            deque.addLast(i);
        }

        for (int val : answer) {
            sb.append(val).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}