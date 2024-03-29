package baekjoon.gold.Num17472;

import java.io.*;
import java.util.*;

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int start, target, distance;

    public Edge(int start, int target, int distance) {
        this.start = start;
        this.target = target;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }
}

public class Main {
    private static final int FAIL = -1;
    private static final int OCEAN = 0;
    private static final int ISLAND = 9;

    static int N, M, islandSize;
    static int[][] map;
    static int[] root;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Deque<Pos> deque;
    static PriorityQueue<Edge> edges;

    static void helper() {
        markIslandNumber();
        init();
        bridgeConstruction();
    }

    static void markIslandNumber() {
        int number = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == ISLAND) {
                    mark(number, i, j);
                    number++;
                }
            }
        }
        islandSize = number - 1;
    }

    static void mark(int number, int x, int y) {
        deque = new ArrayDeque<>();
        deque.add(new Pos(x, y));
        map[x][y] = number;

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }

                if (map[nx][ny] != ISLAND) {
                    continue;
                }

                map[nx][ny] = number;
                deque.add(new Pos(nx, ny));
            }
        }

    }

    static void bridgeConstruction() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                findPossibleStartPoint(i, j);
            }
        }
    }

    static void findPossibleStartPoint(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] == 0) {
                go(x, i + 1, x, i, 0, -1);
                break;
            }
        }
        for (int i = y + 1; i < M; i++) {
            if (map[x][i] == 0) {
                go(x, i - 1, x, i, 0, 1);
                break;
            }
        }
        for (int i = y + 1; i < N; i++) {
            if (map[i][y] == 0) {
                go(i - 1, y, i, y, 1, 0);
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] == 0) {
                go(i + 1, y, i, y, -1, 0);
                break;
            }
        }

    }

    static void go(int startX, int startY, int x, int y, int dirX, int dirY) {
        int bridgeLength = 1;
        while (true) {
            int nx = x + dirX;
            int ny = y + dirY;
            if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || map[startX][startY] == map[nx][ny]) {
                return;
            }

            if (map[nx][ny] != OCEAN) {
                if (bridgeLength < 2) {
                    return;
                }
                edges.add(new Edge(map[startX][startY], map[nx][ny], bridgeLength));
                return;
            }

            bridgeLength++;
            x = nx;
            y = ny;

        }
    }

    static void init() {
        root = new int[islandSize + 1];
        for (int i = 1; i < root.length; i++) {
            root[i] = i;
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (root[pa] < root[pb]) {
            root[pb] = pa;
        } else {
            root[pa] = pb;
        }
    }

    static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    static int choiceBride() {
        int sum = 0;
        int edgeCount = 0;
        while (!edges.isEmpty()) {

            if (edgeCount == islandSize - 1) {
                break;
            }

            Edge cur = edges.poll();
            if (find(cur.start) != find(cur.target)) {
                union(root[cur.start], root[cur.target]);
                sum += cur.distance;
                edgeCount++;
            }
        }

        return edgeCount == islandSize - 1 ? sum : FAIL;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        edges = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    map[i][j] = ISLAND;
                }
            }
        }

        helper();

        bw.write(String.valueOf(choiceBride()));
        br.close();
        bw.close();
    }
}