package baekjoon.gold.Num12851;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer, minTime;
    static int[] times;

    public static void helper() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(N);
        times[N] = 1;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            if (times[cur] > minTime) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int next = cur;
                switch (i) {
                    case 0:
                        next += 1;
                        break;
                    case 1:
                        next -= 1;
                        break;
                    case 2:
                        next *= 2;
                        break;
                }
                if (next < 0 || next > 100000) {
                    continue;
                }
                if (next == K) {
                    answer++;
                    minTime = times[cur];
                }

                if (times[next] == 0 || times[next] == times[cur] + 1) {
                    deque.add(next);
                    times[next] = times[cur] + 1;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = 0;
        minTime = Integer.MAX_VALUE;
        times = new int[100001];

        if (N >= K) {
            minTime = N - K;
            answer = 1;
        } else {
            helper();
        }

        bw.write(minTime + "\n" + answer);
        br.close();
        bw.flush();
        bw.close();
    }
}
