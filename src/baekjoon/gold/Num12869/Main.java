package baekjoon.gold.Num12869;

import java.io.*;
import java.util.*;

class Scv {
    int depth, hp1, hp2, hp3;

    public Scv(int depth, int hp1, int hp2, int hp3) {
        this.depth = depth;
        this.hp1 = hp1;
        this.hp2 = hp2;
        this.hp3 = hp3;
    }
}

public class Main {
    static int N, answer;
    static int[] scv;
    static int[][] dir = new int[][]{{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -9, -3}, {-1, -3, -9}};
    static boolean[][][] visited;
    static Deque<Scv> deque;

    static void helper() {
        visited[scv[0]][scv[1]][scv[2]] = true;
        deque.add(new Scv(0, scv[0], scv[1], scv[2]));
        while (!deque.isEmpty()) {
            Scv cur = deque.poll();
            if (cur.hp1 <= 0 && cur.hp2 <= 0 && cur.hp3 <= 0) {
                answer = cur.depth;
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nhp1 = cur.hp1 + dir[i][0];
                int nhp2 = cur.hp2 + dir[i][1];
                int nhp3 = cur.hp3 + dir[i][2];

                nhp1 = Math.max(nhp1, 0);
                nhp2 = Math.max(nhp2, 0);
                nhp3 = Math.max(nhp3, 0);

                if (visited[nhp1][nhp2][nhp3]) {
                    continue;
                }

                deque.add(new Scv(cur.depth + 1, nhp1, nhp2, nhp3));
                visited[nhp1][nhp2][nhp3] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        scv = new int[3];
        visited = new boolean[61][61][61];
        deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}