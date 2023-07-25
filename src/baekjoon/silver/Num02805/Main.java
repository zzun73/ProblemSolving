package baekjoon.silver.Num02805;

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
        int[] woods = new int[N];
        int min = 0, max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
            max = Math.max(woods[i], max);
        }

        while (min <= max) {
            int height = (max + min) / 2;
            long sum = 0L;
            for (long wood : woods) {
                if (wood - height > 0) {
                    sum += wood - height;
                }
            }

            if (sum >= M) {
                min = height + 1;
            }
            if (sum < M) {
                max = height - 1;
            }
        }
        bw.write(min - 1 + "");

        br.close();
        bw.flush();
        bw.close();

    }
}
