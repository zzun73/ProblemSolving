package baekjoon.silver.Num05014;

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
    static int F, S, G, U, D;
    static boolean[] visited;

    public static int helper() {
        int answer = -1;
        Queue<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(S, 0));

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();
            if (cur.pos == G) {
                answer = cur.count;
                break;
            }
            int up = cur.pos + U;
            int down = cur.pos - D;
            if (up <= F && !visited[up]) {
                visited[up] = true;
                deque.add(new Pos(up, cur.count + 1));
            }
            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                deque.add(new Pos(down, cur.count + 1));
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];
        int answer = helper();

        bw.write(String.valueOf(answer != -1 ? answer : "use the stairs"));

        br.close();
        bw.flush();
        bw.close();
    }
}
