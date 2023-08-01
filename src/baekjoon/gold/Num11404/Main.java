package baekjoon.gold.Num11404;

import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    static long[][] bus;
    static int n;

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    bus[i][j] = Math.min(bus[i][j], bus[i][k] + bus[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        bus = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bus[i][j] = INF;
                if (i == j) {
                    bus[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bus[a][b] = Math.min(bus[a][b], c);
        }

        floyd();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(bus[i][j] == INF ? 0 : bus[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
