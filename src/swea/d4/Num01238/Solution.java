package swea.d4.Num01238;

import java.io.*;
import java.util.*;

class Edge {
    int depth, vertex;

    public Edge(int depth, int vertex) {
        this.depth = depth;
        this.vertex = vertex;
    }
}

public class Solution {
    private static int SIZE = 101;
    static int length, start, maxDepth, answer;
    static Deque<Edge> deque;
    static ArrayList<Integer>[] edges;
    static int[] depth;
    static boolean[] visited;

    static void helper() {
        // 시작 정점 큐에 삽입
        deque.add(new Edge(0, start));
        visited[start] = true;

        while (!deque.isEmpty()) {
            Edge cur = deque.poll();
            maxDepth = Math.max(cur.depth, maxDepth);
            for (int next : edges[cur.vertex]) { // 연결된 간선 확인
                if (!visited[next]) { // 미방문인 경우
                    visited[next] = true;
                    deque.add(new Edge(cur.depth + 1, next));
                    depth[next] = cur.depth + 1; // 깊이 저장
                }
            }
        }

        // 마지막 연락 받은 사람 중 가장 큰 번호가 정답
        for (int i = SIZE - 1; i >= 1; i--) {
            if (depth[i] == maxDepth) {
                answer = i;
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            length = Integer.parseInt(st.nextToken()) / 2;
            start = Integer.parseInt(st.nextToken());

            visited = new boolean[SIZE];
            depth = new int[SIZE];
            edges = new ArrayList[SIZE];
            deque = new ArrayDeque<>();
            answer = maxDepth = 0;
            for (int i = 0; i < SIZE; i++) { // ArrayList 배열생성
                edges[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < length; i++) { // 입력 받기
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (edges[a].contains(b)) { // 중복 간선 제거
                    continue;
                }
                edges[a].add(b);
            }

            helper();
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}