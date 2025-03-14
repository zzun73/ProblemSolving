package baekjoon.gold.Num23843;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> devicePq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> chargePq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            devicePq.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        while (!devicePq.isEmpty()) {
            int curTime = 0;
            if (chargePq.size() < M) {
                curTime = devicePq.poll();
            } else {
                curTime = chargePq.poll() + devicePq.poll();
            }
            chargePq.add(curTime);
            time = Math.max(time, curTime);
        }


        bw.write(String.valueOf(time));

        br.close();
        bw.close();
    }
}