/**
 * Floyd
 */
package baekjoon.silver.Num01389;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        for (int[] row : arr) {
            Arrays.fill(row, 1000000000);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A][B] = arr[B][A] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int sum = Integer.MAX_VALUE, answer = 0;
        for (int i = 1; i <= N; i++) {
            int cur = 0;
            for (int j = 1; j <= N; j++) {
                cur += arr[i][j];
            }
            if (sum > cur) {
                sum = cur;
                answer = i;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
/**
 * bfs
 */
//package baekjoon.silver.Num01389;
//
//import java.io.*;
//import java.util.*;
//
//class Node {
//    int to;
//    int cost;
//
//    public Node(int to, int cost) {
//        this.to = to;
//        this.cost = cost;
//    }
//}
//
//public class Main {
//    static List<Integer>[] list;
//    static boolean[] visited;
//
//    public static int helper(int val) {
//        Deque<Node> deque = new ArrayDeque<>();
//        deque.add(new Node(val, 0));
//        visited[val] = true;
//        int sum = 0;
//        while (!deque.isEmpty()) {
//            Node cur = deque.poll();
//            for (int next : list[cur.to]) {
//                if (!visited[next]) {
//                    sum += cur.cost;
//                    visited[next] = true;
//                    deque.add(new Node(next, cur.cost + 1));
//                }
//            }
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine(), " ");
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        list = new ArrayList[N + 1];
//        visited = new boolean[N + 1];
//        for (int i = 0; i <= N; i++) {
//            list[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int A = Integer.parseInt(st.nextToken());
//            int B = Integer.parseInt(st.nextToken());
//            list[A].add(B);
//            list[B].add(A);
//        }
//
//        int sum = Integer.MAX_VALUE;
//        int answer = -1;
//        for (int i = 1; i <= N; i++) {
//            Arrays.fill(visited, false);
//            int res = helper(i);
//            if (res < sum) {
//                sum = res;
//                answer = i;
//            }
//        }
//        bw.write(String.valueOf(answer));
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}
