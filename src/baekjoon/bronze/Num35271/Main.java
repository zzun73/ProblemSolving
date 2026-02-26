package baekjoon.bronze.Num35271;

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
        int M = Integer.parseInt(st.nextToken());

        int[] count = new int[M + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            int val = Integer.parseInt(st.nextToken());
            count[i] = val;
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int target = -1;
            for (int i = 0; i < 3; i++) {
                int wish = Integer.parseInt(st.nextToken());
                if (count[wish] > 0) {
                    target = wish;
                    count[wish]--;
                    break;
                }
            }

            sb.append(target).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}