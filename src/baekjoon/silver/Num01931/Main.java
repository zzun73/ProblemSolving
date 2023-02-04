package baekjoon.silver.Num01931;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) {
            return o1[0] - o2[0];
        } else {
            return o1[1] - o2[1];
        }
    });

    int answer = 1;
        int cur = time[0][1];
        for (int i = 1; i < N; i++) {
            if (cur > time[i][0]) {
                continue;
            }
            cur = time[i][1];
            answer++;
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
