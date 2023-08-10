package baekjoon.gold.Num01956;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1_000_000_000;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        arr = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                arr[i][j] = INF;
            }
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (arr[i][j] != INF && arr[j][i] != INF) {
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }
        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
