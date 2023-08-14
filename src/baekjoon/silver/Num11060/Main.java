package baekjoon.silver.Num11060;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int pos, count;

    public Pos(int pos, int count) {
        this.pos = pos;
        this.count = count;
    }
}

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static int helper() {
        int answer = -1;
        Queue<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0, 0));

        while (!deque.isEmpty()) {
                Pos cur = deque.poll();
                if (cur.pos == N - 1) {
                    answer = cur.count;
                    break;
                }

                int value = cur.pos + arr[cur.pos];
            for (int i = cur.pos; i <= value && i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    deque.add(new Pos(i, cur.count + 1));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(helper()));
        br.close();
        bw.flush();
        bw.close();
    }
}
