package baekjoon.bronze.Num10162;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] time = new int[]{300, 60, 10};
        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            if (T >= time[i]) {
                answer[i] += T / time[i];
                T %= time[i];
            }
        }

        if (T == 0) {
            System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
        } else {
            System.out.println(-1);
        }

        br.close();
    }
}
