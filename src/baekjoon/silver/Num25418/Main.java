package baekjoon.silver.Num25418;

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int pos, cnt;

        public Node(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    static int A, K;

    static int helper() {
        int res = 0;
        boolean[] visited = new boolean[K + 1];
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(A, 0));
        visited[A] = true;

        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.pos == K) {
                res = cur.cnt;
                break;
            }

            int npos = cur.pos + 1;
            int ncnt = cur.cnt + 1;
            if (npos <= K && !visited[npos]) {
                visited[npos] = true;
                deque.add(new Node(npos, ncnt));
            }

            npos = cur.pos * 2;
            if (npos <= K && !visited[npos]) {
                visited[npos] = true;
                deque.add(new Node(npos, ncnt));
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(helper()));
        br.close();
        bw.close();
    }

}