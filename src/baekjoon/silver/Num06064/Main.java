package baekjoon.silver.Num06064;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            boolean flag = false;
            while (x <= M * N) {
                if ((x - 1) % N + 1 == y) {
                    sb.append(x).append("\n");
                    flag = true;
                    break;
                }
                x += M;
            }

            if (!flag) {
                sb.append("-1").append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}