package baekjoon.silver.Num15787;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] train = new int[N + 1];
        int mask = (1 << 20) - 1;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                train[i] |= (1 << (x - 1));
            } else if (command == 2) {
                int x = Integer.parseInt(st.nextToken());
                train[i] &= ~(1 << (x - 1));
            } else if (command == 3) {
                train[i] = (train[i] << 1) & mask;
            } else if (command == 4) {
                train[i] = (train[i] >> 1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(train[i]);
        }

        bw.write(String.valueOf(set.size()));

        br.close();
        bw.close();
    }
}