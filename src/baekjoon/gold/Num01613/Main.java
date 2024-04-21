package baekjoon.gold.Num01613;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N + 1][N + 1];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] && map[k][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        while (s-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!map[a][b] && map[b][a]) {
                sb.append(1);
            } else if (map[a][b] && !map[b][a]) {
                sb.append(-1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
//package baekjoon.gold.Num01613;
//
//import java.io.*;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//    private static final int INF = 100_000_000;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        st = new StringTokenizer(br.readLine(), " ");
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int[][] map = new int[N + 1][N + 1];
//
//        for (int[] row : map) {
//            Arrays.fill(row, INF);
//        }
//        while (K-- > 0) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            map[a][b] = 1;
//        }
//
//        for (int k = 1; k <= N; k++) {
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
//                }
//            }
//        }
//
//        int s = Integer.parseInt(br.readLine());
//        while (s-- > 0) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            if (map[a][b] == INF && map[b][a] != INF) {
//                sb.append(1);
//            } else if (map[a][b] != INF && map[b][a] == INF) {
//                sb.append(-1);
//            } else {
//                sb.append(0);
//            }
//            sb.append("\n");
//        }
//
//        bw.write(sb.toString());
//
//        br.close();
//        bw.close();
//    }
//}