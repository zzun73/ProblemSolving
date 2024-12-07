package baekjoon.gold.Num14226;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Emoticon {
    int position, clipboard, time;

    public Emoticon(int position, int clipboard, int time) {
        this.position = position;
        this.clipboard = clipboard;
        this.time = time;
    }
}

public class Main {
    static int N, answer;
    static boolean[][] visited;
    static Deque<Emoticon> deque;


    static void helper() {
        deque = new ArrayDeque<>();
        visited = new boolean[2001][2001];
        deque.add(new Emoticon(1, 0, 0));
        visited[1][0] = true;

        while (!deque.isEmpty()) {
            Emoticon cur = deque.poll();
            if (cur.position == N) {
                answer = cur.time;
                break;
            }
            if (!visited[cur.position][cur.position]) {
                visited[cur.position][cur.position] = true;
                deque.add(new Emoticon(cur.position, cur.position, cur.time + 1));
            }
            if (cur.clipboard != 0 && cur.position + cur.clipboard <=2000 && !visited[cur.position + cur.clipboard][cur.position]) {
                visited[cur.position + cur.clipboard][cur.clipboard] = true;
                deque.add(new Emoticon(cur.position + cur.clipboard, cur.clipboard, cur.time + 1));
            }
            if (cur.position > 0 && !visited[cur.position - 1][cur.clipboard]) {
                visited[cur.position - 1][cur.clipboard] = true;
                deque.add(new Emoticon(cur.position - 1, cur.clipboard, cur.time + 1));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}