package baekjoon.gold.Num16236;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[][] map;
    static Shark shark;
    static PriorityQueue<Fish> fishList;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static class Shark {
        int x, y, size, exp;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
            this.exp = 0;
        }

        private void eat() {
            if (++exp == size) {
                size++;
                exp = 0;
            }
        }
    }

    static class Fish implements Comparable<Fish> {
        int x, y, distance;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.distance == o.distance) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.distance - o.distance;
        }

    }

    static void helper() {

        while (true) {
            findEatFish();

            if (fishList.isEmpty()) {
                break;
            }

            Fish targetFish = fishList.poll();
            map[targetFish.x][targetFish.y] = 0;
            shark.x = targetFish.x;
            shark.y = targetFish.y;
            shark.eat();

            answer += targetFish.distance;
        }
    }

    static void findEatFish() {
        Deque<Fish> deque = new ArrayDeque<>();
        fishList = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];

        deque.add(new Fish(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;

        while (!deque.isEmpty()) {
            Fish cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || shark.size < map[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] != 0 && map[nx][ny] < shark.size) {
                    fishList.add(new Fish(nx, ny, cur.distance + 1));
                }
                visited[nx][ny] = true;
                deque.add(new Fish(nx, ny, cur.distance + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}