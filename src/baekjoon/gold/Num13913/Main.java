package baekjoon.gold.Num13913;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K, time;
    static int[] parent;
    static boolean[] visited;
    static List<Integer> list;
    static ArrayDeque<int[]> deque;

    public static void bfs() {
        deque.add(new int[]{N, 0});
        parent[N] = N;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int curVal = cur[0];
            int curTime = cur[1];

            if (curVal == K) {
                time = curTime;
                break;
            }

            if (isValid(curVal + 1)) {
                insertAndMark(curVal, curVal + 1, cur[1] + 1);
            }
            if (isValid(curVal - 1)) {
                insertAndMark(curVal, curVal - 1, cur[1] + 1);
            }
            if (isValid(curVal * 2)) {
                insertAndMark(curVal, curVal * 2, cur[1] + 1);
            }
        }
    }

    public static void dfs(int val) {
        if (val == N) {
            list.add(val);
            return;
        }
        if (!visited[val]) {
            list.add(val);
            visited[val] = true;
            dfs(parent[val]);
        }
    }

    private static boolean isValid(int curVal) {
        return curVal >= 0 && curVal <= 100000 && parent[curVal] == -1;
    }

    private static void insertAndMark(int preVal, int curVal, int curDepth) {
        deque.add(new int[]{curVal, curDepth});
        parent[curVal] = preVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        deque = new ArrayDeque<>();
        parent = new int[100001];
        visited = new boolean[100001];
        Arrays.fill(parent, -1);
        list = new ArrayList<>();
        time = 0;

        bfs();
        dfs(K);

        sb.append(time).append("\n");
        Collections.reverse(list);

        for (Integer val : list) {
            sb.append(val).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
