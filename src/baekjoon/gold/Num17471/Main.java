package baekjoon.gold.Num17471;

import java.io.*;
import java.util.*;

public class Main {
    private static final int FAILURE = Integer.MAX_VALUE;
    static int N, answer;
    static int[] people;
    static boolean[] selected;
    static List<Integer>[] edges;

    static void helper(int count) {
        if (count == N) {
            List<Integer> teamA = new ArrayList<>();
            List<Integer> teamB = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (selected[i]) {
                    teamA.add(i);
                } else {
                    teamB.add(i);
                }
            }

            if (teamA.isEmpty() || teamB.isEmpty()) {
                return;
            }

            if (isConnect(teamA) && isConnect(teamB)) {
                answer = Math.min(answer, calcPopulationDiff());
            }
            return;
        }

        selected[count] = true;
        helper(count + 1);
        selected[count] = false;
        helper(count + 1);
    }


    static boolean isConnect(List<Integer> team) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[team.get(0)] = true;
        deque.add(team.get(0));

        int count = 1;
        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : edges[cur]) {
                if (!visited[next] && team.contains(next)) {
                    visited[next] = true;
                    count++;
                    deque.add(next);
                }
            }
        }
        return count == team.size();
    }

    static int calcPopulationDiff() {
        int teamASum = 0, teamBSum = 0;
        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                teamASum += people[i];
            } else {
                teamBSum += people[i];
            }
        }
        return Math.abs(teamASum - teamBSum);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        selected = new boolean[N + 1];
        edges = new ArrayList[N + 1];

        answer = FAILURE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            while (size-- > 0) {
                int val = Integer.parseInt(st.nextToken());
                edges[i].add(val);
            }
        }

        helper(0);
        if (answer == FAILURE) {
            answer = -1;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}

/**
 * union-find
 */
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    private static final int FAILURE = Integer.MAX_VALUE;
//    static int N, val, sumA, sumB, answer;
//    static int[] people, root;
//    static boolean[] visited, checked;
//    static List<Integer>[] edges;
//    static Deque<Integer> dequeA, dequeB;
//
//    static void init() {
//        for (int i = 1; i <= N; i++) {
//            root[i] = i;
//        }
//    }
//
//    static int find(int x) {
//        if (root[x] == x) {
//            return x;
//        }
//        return root[x] = find(root[x]);
//    }
//
//    static void union(int a, int b) {
//        int pa = find(a);
//        int pb = find(b);
//
//        if (root[pa] < root[pb]) {
//            root[pb] = pa;
//        } else {
//            root[pa] = pb;
//        }
//    }
//
//    static void helper(int count) {
//
//        if (count == N) {
//            splitTeam();
//            return;
//        }
//
//        visited[count] = true;
//        helper(count + 1);
//        visited[count] = false;
//        helper(count + 1);
//    }
//
//    static void splitTeam() {
//        dequeA = new ArrayDeque<>();
//        dequeB = new ArrayDeque<>();
//        sumA = sumB = 0;
//
//        for (int i = 1; i <= N; i++) {
//            if (visited[i]) {
//                dequeA.add(i);
//            } else {
//                dequeB.add(i);
//            }
//        }
//
//        if (dequeA.isEmpty() || dequeB.isEmpty()) {
//            return;
//        }
//
//        init();
//        connectTeam(dequeA, true);
//        sumA = check(dequeA, true);
//        if (sumA == FAILURE) {
//            return;
//        }
//
//        init();
//        connectTeam(dequeB, false);
//        sumB = check(dequeB, false);
//        if (sumB == FAILURE) {
//            return;
//        }
//
//        answer = Math.min(answer, Math.abs(sumA - sumB));
//    }
//
//    static void connectTeam(Deque<Integer> deque, boolean team) {
//        for (int cur : deque) {
//            for (int val : edges[cur]) {
//                if (visited[cur] == visited[val] && visited[cur] == team) {
//                    union(cur, val);
//                }
//            }
//        }
//    }
//
//    static int check(Deque<Integer> deque, boolean team) {
//        int sum = 0;
//        checked = new boolean[N + 1];
//        int prev = find(deque.peek());
//
//        while (!deque.isEmpty()) {
//            int cur = deque.poll();
//
//            // 아직 방문하지 않은 곳이면서 연결되어있는 정점
//            if (!checked[cur] && isConnect(prev, cur)) {
//                checked[cur] = true;
//                sum += people[cur];
//                prev = cur;
//            } else {
//                return FAILURE;
//            }
//        }
//        return sum;
//    }
//
//    static boolean isConnect(int prev, int cur) {
//        return find(prev) == find(cur);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        N = Integer.parseInt(br.readLine());
//        people = new int[N + 1];
//        visited = new boolean[N + 1];
//        checked = new boolean[N + 1];
//        edges = new ArrayList[N + 1];
//        root = new int[N + 1];
//
//        answer = FAILURE;
//        init();
//
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 1; i <= N; i++) {
//            people[i] = Integer.parseInt(st.nextToken());
//        }
//
//
//        for (int i = 1; i <= N; i++) {
//            edges[i] = new ArrayList<>();
//            st = new StringTokenizer(br.readLine(), " ");
//            int size = Integer.parseInt(st.nextToken());
//            for (int j = 0; j < size; j++) { // 인접한 구역의 번호
//                val = Integer.parseInt(st.nextToken()); // 인접한 구역의 수
//                edges[i].add(val);
//            }
//        }
//
//        helper(0);
//        if (answer == FAILURE) {
//            answer = -1;
//        }
//
//        bw.write(String.valueOf(answer));
//        br.close();
//        bw.close();
//    }
//}