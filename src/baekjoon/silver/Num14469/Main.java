package baekjoon.silver.Num14469;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cow = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cow, (n1, n2) -> {
            if (n1[0] == n2[0]) {
                return n1[1] - n2[1];
            }
            return n1[0] - n2[0];
        });

        int answer = cow[0][0] + cow[0][1];
        for (int i = 1; i < N; i++) {
            if (answer <= cow[i][0]) {
                answer = cow[i][0] + cow[i][1];
            } else {
                answer += cow[i][1];
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
