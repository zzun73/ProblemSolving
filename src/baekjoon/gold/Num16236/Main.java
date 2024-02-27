package baekjoon.gold.Num16236;

import java.io.*;
import java.util.*;

class Shark {
    int x, y, size, count, distance;

    public Shark(int x, int y, int size, int distance) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.distance = distance;
        count = 0;
    }

    public void eat(Fish target) {
        this.x = target.x;
        this.y = target.y;
        count++;

        if (count == size) { // 크기만큼 물고기 먹으면
            size++; // 사이즈 증가시켜주기
            count = 0;
        }
    }
}

class Fish implements Comparable<Fish> {
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
            } else {
                return this.x - o.x;

            }
        }
        return this.distance - o.distance;
    }

}

public class Main {
    static int N, time;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static Shark shark;
    static PriorityQueue<Fish> fishes;
    static Deque<Shark> deque;

    static boolean helper() {
        return search() && helper();
    }

    static boolean search() {
        visited = new boolean[N][N];
        fishes = new PriorityQueue<>();

        deque.add(shark);
        visited[shark.x][shark.y] = true;
        while (!deque.isEmpty()) {
            Shark cur = deque.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 범위 밖 or 이미 방문 or 나보다 큰 물고기인 경우
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || visited[nx][ny] || shark.size < map[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                deque.add(new Shark(nx, ny, map[nx][ny], cur.distance + 1));

                // 내가 먹을 수 있는 물고기인 경우
                if (map[nx][ny] != 0 && shark.size > map[nx][ny]) {
                    fishes.add(new Fish(nx, ny, cur.distance + 1));
                }

            }
        }

        return isPossibleEat();
    }

    static boolean isPossibleEat() {
        if (fishes.isEmpty()) {
            return false;
        }
        Fish targetFish = fishes.poll();
        shark.eat(targetFish);

        time += targetFish.distance;
        map[targetFish.x][targetFish.y] = 0;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        fishes = new PriorityQueue<>();
        deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 상어인 경우
                    shark = new Shark(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }
        helper();

        bw.write(String.valueOf(time));
        br.close();
        bw.close();
    }
}
