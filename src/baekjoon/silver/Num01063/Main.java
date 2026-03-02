package baekjoon.silver.Num01063;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final Map<String, int[]> DIR = Map.of(
            "R", new int[]{1, 0},
            "L", new int[]{-1, 0},
            "B", new int[]{0, -1},
            "T", new int[]{0, 1},
            "RT", new int[]{1, 1},
            "LT", new int[]{-1, 1},
            "RB", new int[]{1, -1},
            "LB", new int[]{-1, -1}
    );

    static boolean isOut(int x, int y) {
        return x < 1 || x > 8 || y < 1 || y > 8;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        String first = st.nextToken();
        String second = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int[] king = new int[]{first.charAt(0) - 'A' + 1, first.charAt(1) - '0'};
        int[] stone = new int[]{second.charAt(0) - 'A' + 1, second.charAt(1) - '0'};

        while (N-- > 0) {
            String command = br.readLine();
            int[] cmd = DIR.get(command);

            int kx = king[0] + cmd[0];
            int ky = king[1] + cmd[1];

            if (isOut(kx, ky)) {
                continue;
            }

            if (kx == stone[0] && ky == stone[1]) {
                int sx = stone[0] + cmd[0];
                int sy = stone[1] + cmd[1];

                if (isOut(sx, sy)) {
                    continue;
                }
                stone[0] = sx;
                stone[1] = sy;
            }

            king[0] = kx;
            king[1] = ky;
        }
        sb.append((char) ('A' + king[0] - 1)).append(king[1]).append("\n")
                .append((char) ('A' + stone[0] - 1)).append(stone[1]);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}