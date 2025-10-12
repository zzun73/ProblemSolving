package baekjoon.bronze.Num15923;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int px = sx, py = sy;
        int answer = 0;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            answer += Math.abs(x - px) + Math.abs(y - py);
            px = x;
            py = y;
        }

        answer += Math.abs(sx - px) + Math.abs(sy - py);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}