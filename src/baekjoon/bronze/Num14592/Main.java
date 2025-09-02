package baekjoon.bronze.Num14592;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Player {
        int idx, s, c, l;

        Player(int idx, int s, int c, int l) {
            this.idx = idx;
            this.s = s;
            this.c = c;
            this.l = l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Player> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            list.add(new Player(i, s, c, l));
        }

        list.sort((a, b) -> {
            if (a.s != b.s) return b.s - a.s;
            if (a.c != b.c) return a.c - b.c;
            return a.l - b.l;
        });

        bw.write(String.valueOf(list.get(0).idx));

        br.close();
        bw.close();
    }
}