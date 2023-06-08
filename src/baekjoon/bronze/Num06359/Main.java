package baekjoon.bronze.Num06359;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] room = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k * j <= N; k++) {
                    if (room[k * j] == 0) {
                        room[k * j] = 1;
                    } else {
                        room[k * j] = 0;
                    }
                }
            }

            int answer = 0;
            for (int j = 1; j <= N; j++) {
                answer += room[j];
            }
            bw.write(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
