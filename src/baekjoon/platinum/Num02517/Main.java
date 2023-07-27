package baekjoon.platinum.Num02517;

import java.io.*;
import java.util.*;

class Player implements Comparable<Player> {
    int id;
    int speed;

    public Player(int id, int speed) {
        this.id = id;
        this.speed = speed;
    }

    @Override
    public int compareTo(Player p) {
        return p.speed - this.speed;
    }
}

public class Main {
    static int offset;
    static int[] indexedTree;

    private static void update(int id) {
        while (id > 1) {
            id /= 2;
            indexedTree[id] = indexedTree[id * 2] + indexedTree[id * 2 + 1];
        }
    }

    private static int sum(int l, int r) {
        int sum = 0;
        while (l <= r) {
            if ((l & 1) == 1) sum += indexedTree[l++];
            if ((r & 1) == 0) sum += indexedTree[r--];

            l /= 2;
            r /= 2;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] rank = new int[N];
        List<Player> players = new ArrayList<>();

        offset = 1;
        while (offset < N) {
            offset *= 2;
        }

        indexedTree = new int[offset * 2 + 1];
        for (int i = 0; i < N; i++) {
            players.add(new Player(i, Integer.parseInt(br.readLine())));
        }
        Collections.sort(players);

        for (Player p : players) {
            int curPos = p.id + offset;
            indexedTree[curPos] = 1;
            update(curPos);
            rank[p.id] = sum(offset, curPos);
        }

        StringBuilder sb = new StringBuilder();
        for (int r : rank) {
            sb.append(r).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();

    }
}
