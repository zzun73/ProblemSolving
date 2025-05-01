package baekjoon.silver.Num01268;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MIN_VALUE;
        int answer = 0;
        for (int t = 0; t < N; t++) {
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < N; i++) {
                    if (arr[t][j] == arr[i][j]) {
                        set.add(i);
                    }
                }
            }

            if (set.size() > min) {
                answer = t + 1;
                min = set.size();
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}